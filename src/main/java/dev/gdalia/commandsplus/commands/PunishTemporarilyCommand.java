package dev.gdalia.commandsplus.commands;

import dev.gdalia.commandsplus.models.PunishmentManager;
import dev.gdalia.commandsplus.models.Punishments;
import dev.gdalia.commandsplus.structs.BasePlusCommand;
import dev.gdalia.commandsplus.structs.Message;
import dev.gdalia.commandsplus.structs.Permission;
import dev.gdalia.commandsplus.structs.punishments.Punishment;
import dev.gdalia.commandsplus.structs.punishments.PunishmentType;
import dev.gdalia.commandsplus.utils.CommandAutoRegistration;
import dev.gdalia.commandsplus.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@CommandAutoRegistration.Command(value = {"tempmute", "tempban"})
public class PunishTemporarilyCommand extends BasePlusCommand {

	public PunishTemporarilyCommand() {
		super(false, "tempmute", "tempban");
	}

	@Override
	public String getDescription() {
		return "Temporarily punish players on/out the server.";
	}

	@Override
	public String getSyntax() {
		return "/(tempban || tempmute) [player] [time(TAB)] [reason]";
	}

	@Override
	public Permission getRequiredPermission() {
		return Permission.PERMISSION_PUNISH;
	}

	@Override
	public boolean isPlayerCommand() {
		return false;
	}

	@Override
	public @Nullable Map<Integer, List<TabCompletion>> tabCompletions() {
		return Map.of(2, List.of(new TabCompletion(List.of("1s", "1m", "1h", "1d", "1w", "1M", "1y"), Permission.PERMISSION_PUNISH)));
	}

	@Override
	public void runCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
		String typeString = cmd.getName().replace("TEMP", "").toUpperCase();
		PunishmentType type = PunishmentType.canBeType(typeString) ? PunishmentType.valueOf(typeString) : null;

		if (!Permission.valueOf("PERMISSION_" + type.name()).hasPermission(sender)) {
			Message.playSound(sender, Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
			Message.COMMAND_NO_PERMISSION.sendMessage(sender, true);
			return;
		}
		
		if (args.length <= 2) {
			Message.playSound(sender, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 1);
			sender.sendMessage(ChatColor.GRAY + getSyntax());
			return;
		}
		
		OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
		
        if (!target.hasPlayedBefore()) {
        	Message.PLAYER_NOT_EXIST.sendMessage(sender, true);
        	Message.playSound(sender, Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            return;
        }
        
        Punishments.getInstance().getActivePunishment(target.getUniqueId(), PunishmentType.valueOf(type.name().toUpperCase()), PunishmentType.valueOf(type.name().replace("TEMP", "").toUpperCase()))
				.ifPresentOrElse(punishment -> {
					type.getAlreadyPunishedMessage().sendMessage(sender, true);
					Message.playSound(sender, Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
				}, () -> {
					Duration duration;

					try {
						duration = StringUtils.phraseToDuration(args[1],
								ChronoUnit.SECONDS, ChronoUnit.MINUTES,
								ChronoUnit.HOURS, ChronoUnit.DAYS,
								ChronoUnit.WEEKS, ChronoUnit.MONTHS,
								ChronoUnit.YEARS);
					} catch (IllegalStateException ex1) {
						Message.playSound(sender, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 1);
						sender.sendMessage(ChatColor.GRAY + getSyntax());
						return;
					}

					String message = org.apache.commons.lang.StringUtils.join(args, " ", 2, args.length);
					Instant expiry = Instant.now().plus(duration);

					Punishment punishment = new Punishment(
						UUID.randomUUID(),
						target.getUniqueId(),
							Optional.of(sender)
									.filter(Player.class::isInstance)
									.map(Player.class::cast)
									.map(Player::getUniqueId)
									.orElse(null),
						type,
						message,
						false);

					punishment.setExpiry(expiry);
					PunishmentManager.getInstance().invoke(punishment);
					Message.playSound(sender, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);

					/*Instant one = Instant.now();
					Instant two = punishment.getExpiry();
					Duration res = Duration.between(one, two);*/

					type.getPunishSuccessfulMessage().sendFormattedMessage(sender, true, target.getName(), StringUtils.formatTime(duration));
					/*Message.valueOf("PLAYER_" + type.getNameAsPunishMsg().toUpperCase() + "_MESSAGE")
							.sendFormattedMessage(sender, true, target.getName(), StringUtils.formatTime(res));*/
				});
    }
}
