package de.lycake.CakeBananaPlugin;

import org.bukkit.event.block.BlockListener;

public class BananaBlockListener extends BlockListener{
	private CakeBananaPlugin plugin_;
	
	public BananaBlockListener(CakeBananaPlugin plugin){
		plugin_ = plugin;
	}
}
