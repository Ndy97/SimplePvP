package com.andy;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockListener implements Listener{
	
	public SimplePvP plugin;

	public BlockListener(SimplePvP plugin) {
		plugin = this.plugin;
	}

	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event){
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
        Sign sign = (Sign) block.getState();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
        	if ((block.getType() == Material.SIGN_POST) || (block.getType() == Material.WALL_SIGN)){
        		if(sign.getLine(0).equalsIgnoreCase("§2[PVP]")){
        			if(player.hasPermission("simplepvp.sign")){
        				player.performCommand("pvpjoin" + " " + sign.getLine(1));
        			}
        		}
}
        	}
        }
	@EventHandler
	public void onPlayerChooseKit(PlayerInteractEvent e){
		Player player = e.getPlayer();
		Block block = e.getClickedBlock();
        Sign sign = (Sign) block.getState();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
        	if ((block.getType() == Material.SIGN_POST) || (block.getType() == Material.WALL_SIGN)){
        		if(sign.getLine(0).equalsIgnoreCase("§2[kit]"))
        			if(player.hasPermission("simplepvp.sign")){
        				player.performCommand("pvpkit" + " " + sign.getLine(1));
        			}
        	}
        }
	}
	@EventHandler
	public void onSignChange(SignChangeEvent evt){
		Player player = evt.getPlayer();
		if(evt.getLine(0).equalsIgnoreCase("[PVP]")){
			if(player.hasPermission("simplepvp.admin")){
				evt.setLine(0, "§2[PvP]");
				player.sendMessage(ChatColor.YELLOW + "SimplePvP Sign created!");
			}
		}
		if(evt.getLine(0).equalsIgnoreCase("[KIT]")){
			if(player.hasPermission("simplepvp.admin")){
				if(evt.getLine(1).isEmpty()){
					player.sendMessage(ChatColor.RED + "Please put the name of a kit in Line2!");
					evt.setCancelled(true);
				}else{
					evt.setLine(0, "§2[Kit]");
					player.sendMessage(ChatColor.YELLOW + "Kitsign created!");
				}
			}
		}
	}
}
