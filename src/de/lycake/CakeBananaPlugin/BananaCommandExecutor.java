package de.lycake.CakeBananaPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BananaCommandExecutor implements CommandExecutor{
	private CakeBananaPlugin plugin_;

	public BananaCommandExecutor(CakeBananaPlugin plugin) {
		plugin_ = plugin;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		return false;
	}

}
