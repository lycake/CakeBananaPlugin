package de.lycake.CakeBananaPlugin;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CakeBananaPlugin extends JavaPlugin{
	private Logger log_;

	private BananaCommandExecutor cmdExecutor_;
	
	private PluginManager pm_;
	private BananaPlayerListener playerListener_;
	private BananaBlockListener blockListener_;

	@Override
	public void onDisable() {
		//PluginManager / Event Listeners
		pm_ = getServer().getPluginManager();
		playerListener_ = new BananaPlayerListener(this);
		blockListener_ = new BananaBlockListener(this);
		
		//Player Events
		//registerPlayerEvent(Event.Type, Event.Priority)
		
		//BlockEvents
		//registerBlockEvent(Event.Type, Event.Priority)
		
		
		//Logger
		log_ = Logger.getLogger("Minecraft");
		sendConsoleMessage("CakeBananaPlugin loaded");
		
		//Commands
		cmdExecutor_ = new BananaCommandExecutor(this);
		//registerCommand("commandName");
	}

	@Override
	public void onEnable() {
		sendConsoleMessage("CakeBananaPlugin unloaded");
		
	}
	
	/**
	 * Sends a message to the server console
	 * @param msg the message that will be send to the server
	 */
	public void sendConsoleMessage(String msg){
		log_.info(msg);
	}

	/**
	 * Registers a command for the custom command executor
	 * @param cmd the command that will be registered
	 */
	private void registerCommand(String cmd){
		getCommand("cmd").setExecutor(cmdExecutor_);
	}
	
	/**
	 * Registers a player event
	 * @param type type of the event. Has to be a player event
	 * @param priority the priority of the event
	 */
	private void registerPlayerEvent(Event.Type type, Event.Priority priority){
		pm_.registerEvent(type, playerListener_, priority, this);
	}
	
	/**
	 * Registers a block event
	 * @param type type of the event. Has to be a block event
	 * @param priority the priority of the event
	 */
	private void registerBlockEvent(Event.Type type, Event.Priority priority){
		pm_.registerEvent(type, blockListener_, priority, this);
	}
}
