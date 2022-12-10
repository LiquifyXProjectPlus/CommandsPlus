package dev.gdalia.commandsplus.structs;

import dev.gdalia.commandsplus.Main;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.MessageFormat;

@AllArgsConstructor
public enum Message {

	//ALTS
	ALTS_BANNED("&7You have &c&lBanned &6{0}&7 alts."),
	ALTS_CHECK("&7The player &6{0}&7 has no alts."),
	ALTS_KICKED("&7You have &c&lKicked &6{0}&7 alts."),
	ALTS_ONLINE("&7The player &6{0}&7 has the following alts online:"),

	//MISCELLANEOUS
	BUILDMODE_MSG("&7You have {0} &7your buildmode."),
	CHANGE_THE_TIME("&7The time has been set to &6{0}&7."),

	//CHAT
	CHAT_LOCKED("&7The chat is &c&lLocked&7 you cannot send messages."),
	CHAT_LOCK_BROADCAST("&7The chat has been &c&lLocked&7."),
	CHAT_UNLOCK_BROADCAST("&7The chat has been &a&lUnlocked&7."),

	//FEED
	FEED_BY_TARGET("&6{0} &7fed your appetite."),
	FEED_PLAYER("&7Your appetite was fed."),
	FEED_TARGET("&7you fed &6{0}&7's appetite."),

	//FREEZE
	FREEZE_MESSAGE("&cYou are frozen and cannot move."),
	FREEZE_PLAYER("&7You froze &6{0}&7."),
	FREEZE_TARGET("&7You were frozen by &6{0}&7."),

	//FLIGHT
	FLIGHT_MSG_TO_OTHER("&7You {0} &6{1}&7's flight."),
	FLIGHT_TOGGLE("&7Your flight has been {0}&7."),
	FLIGHT_TOGGLE_BY_OTHER("&7Your flight has been {0}&7 by &6{1}&7."),
	FLIGHT_SPEED_ADJUSTED("&7flight speed adjusted to &a{0}&7."),

	//GAMEMODE
	GAMEMODE_ALREADY_SET("&cYou are already on game mode &6{0}&c."),
	GAMEMODE_ALREADY_SET_OTHER("&6{0}&c is already on gamemode &6{1}&c."),
	GAMEMODE_CHANGED("&7Set own game mode to &6{0} &7Mode."),
	GAMEMODE_CHANGED_BY_OTHER("&7Game mode has been set to &6{0} &7by &6{1}."),
	GAMEMODE_CHANGED_OTHER("&7The game mode of &6{0}&7 has been changed to &6{1}&7."),

	//GODMODE
	GODMODE_TOGGLE("&7You have {0}&7 your god mode."),
	GODMODE_TOGGLE_BY_OTHER("&7Your god mode has been {0}&7 by &6{1}&7."),
	GODMODE_TOGGLE_TO_PLAYER("&7You have {0} &6{1}&7's god mode."),

	//HEAL
	HEAL_BY_PLAYER("&7Your health was restored back to &a{0} &7by &6{1}&7."),
	HEAL_PLAYER("&7You restored your health back to &a{0}&7."),
	HEAL_TARGET("&7Restored &6{0}&7's health back to &a{1}&7."),

	//PUNISH - BAN
	PUNISH_BAN_ALREADY_BANNED("&cThat player is already banned."),
	PUNISH_BAN_SUBMITTED("&7You have &cPermanently&7 banned &6{0}&7."),

	//PUNISH - TEMPBAN
	PUNISH_TEMPBAN_ALREADY_BANNED("&cThat player is already temporarily banned."),
	PUNISH_TEMPBAN_SUBMITTED("&7You have &cTemporarily &7banned &6{0}&7 for &6{1}&7."),

	//PUNISH - NON-CONSTRICTIVE
	PUNISH_KICK_SUBMITTED("&7You have kicked &6{0}&7 from the server."),
	PUNISH_WARN_MESSAGE("&7You have been warned &6{0}&7."),

	//PUNISH - MUTE
	PUNISH_MUTE_SUBMITTED("&7You have &cPermanently&7 muted &6{0}&7."),
	PUNISH_MUTE_ALREADY_MUTED("&cThat player is already muted."),
	PUNISH_MUTE_MESSAGE("&cYou are permanently muted in the server."),
	PUNISH_MUTE_NOT_MUTED("&cThat player is not muted."),
	PUNISH_MUTE_CHAT_DENIED("&cYou are permanently muted, no more chat for you."),

	//PUNISH - TEMPMUTE
	PUNISH_TEMPMUTE_SUBMITTED("&7You have &cTemporarily&7 muted &6{0}&7 for &6{1}&7."),
	PUNISH_TEMPMUTE_MESSAGE("&cYou have been are temporarily muted for &6{0}&c from this server."),
	PUNISH_TEMPMUTE_CHAT_DENIED("&cYou are temporarily muted, your mute will expire in &6{0}&c."),
	PUNISH_TEMPMUTE_ALREADY_MUTED("&cThat player is already temporarily muted."),

	//PUNISH - REVOKE
	PUNISH_REVOKE_UNBAN("&7You have unbanned &6{0}&7."),
	PUNISH_REVOKE_UNMUTE("&7You have unmuted &6{0}&7."),
	PUNISH_REVOKE_UNMUTE_MESSAGE("&7You have been unmuted by &6{0}&7."),

	//PUNISH - INFO
	PUNISH_HISTORY_EMPTY("&cThis player has no punishment history in the system."),
	PUNISH_CHECK_ACTIVE("&cThis player currently has active punishments."),
	PUNISH_CHECK_NO_ACTIVE("&cThe player has no active punishments."),

	//REPORT
	REPORT_SUBMITTED("&7You have successfully reported &c{0}&7 for &e{1}&7."),
	REPORT_DELETED("&7You have successfully &c&lDELETED &7the report of &e{0}&7."),
	REPORT_COMMENT_DELETED("&7You have successfully &c&lDELETED &7the comment of &e{0}&7."),
	REPORT_NOT_EXIST("&cThere is no such report id in the system."),

	COMMAND_NO_PERMISSION("&cYou don't have permission to execute this command."),
	COMMAND_NOT_EXIST("&cThis command does not exist."),
	COMMAND_ONLY_PLAYER("&cThis command can only be used by players."),
	CONTACT_AN_ADMIN("&cConfig reasons is not right, please contact an admin."),
	DESCRIBE_PLAYER("&cPlease describe a player."),
	PLAYER_NOT_ONLINE("&cPlayer is not online."),
	PLAYER_NOT_EXIST("&cPlayer does not exist in Mojang's database."),
	STAFFCHAT_TOGGLE("&7You have {0} &7your staffchat."),
	TPALL("&7You have teleported everyone to &6{0}&7."),
	TPHERE("&6{0} &7has been teleported to you."),
	TYPE_AN_COMMENT("&7Please type in the chat a comment."),
	UNFREEZE_PLAYER("&7You unfroze &6{0}&7."),
	UNFREEZE_TARGET("&7You have been unfrozen by &6{0}&7."),
	VANISH_TOGGLE("&7Vanish mode is now {0}&7.");

	@Getter
	private final String
			defaultMessage;

	public String getMessage() {
		return Message.fixColor(Main.getInstance().getLanguageConfig().getString(this.name()));
	}

	public static String fixColor(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public void sendMessage(CommandSender sender, boolean hasPrefix) {
		String prefix = hasPrefix ? Main.getInstance().getPluginPrefix() : "";
		sender.sendMessage(prefix + getMessage());

	}

	public static void playSound(CommandSender sender, Sound sound, float volume, float pitch) {
		if (!(sender instanceof Player player)) return;
		if (Main.getInstance().getConfig().getBoolean("disable_sounds")) return;
		player.playSound(player.getLocation(), sound, volume, pitch);
	}

	public static void playBumpSound(CommandSender sender) {
		playSound(sender, Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
	}

	public void sendFormattedMessage(CommandSender sender, boolean hasPrefix, Object... objects) {
		String prefix = hasPrefix ? Main.getInstance().getPluginPrefix() : "";
		sender.sendMessage(prefix + MessageFormat.format(getMessage(), objects));
	}

	public static void cmdUsage(Command cmd, CommandSender sender) {
		sender.sendMessage(Message.fixColor("&3" + cmd.getDescription() + "\n&b" + cmd.getUsage()));
	}

	public static String staffChatFormat() {
		return Message.fixColor("&8[&bSTAFF&8] &7{player} &6» &e{message}");
	}

}
