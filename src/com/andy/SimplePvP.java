/**
 * This is the main Class
 */
package com.andy;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class SimplePvP extends JavaPlugin{
	
	private int version = (int) 0.5;
	
	@Override
	public void onEnable(){
		System.out.println("SimplePvP enabled!");
		loadConfig();
	}
	@Override
	public void onDisable(){
		System.out.println("SimplePvP shut down");
	}
	private void loadConfig(){
		FileConfiguration cfg = this.getConfig();
		cfg.options().copyDefaults(true);
		this.saveConfig();
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("pvphelp")){
			if(!(sender instanceof Player)){
				System.out.println("This is a player Command! sry");
	            return false;
			}
			if (args.length == 0){
				Player player = (Player) sender;
				player.sendMessage(ChatColor.RED + "-----");
				player.sendMessage(ChatColor.YELLOW + "Commands:");
				player.sendMessage(ChatColor.YELLOW + "/pvphelp:"+ ChatColor.WHITE + " Show this text.");
				player.sendMessage(ChatColor.YELLOW + "/pvpinfo:"+ ChatColor.WHITE + " Shows Information about the Plugin and the Developer (me :D).");
				player.sendMessage(ChatColor.YELLOW + "/pvphelp player:"+ ChatColor.WHITE + " Show the player Commands.");
				player.sendMessage(ChatColor.YELLOW + "/pvphelp admin:"+ ChatColor.WHITE + " Show the admin Commands.");
				player.sendMessage(ChatColor.RED + "-----");
				return true;
			}
            if (args[0].equalsIgnoreCase("player")){
            	Player player = (Player) sender;
            	player.sendMessage(ChatColor.RED + "-----");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin red:" + ChatColor.WHITE + " Used to join Team " + ChatColor.RED + "Red");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin blue:" + ChatColor.WHITE + " Used to join Team " + ChatColor.BLUE + "Blue");
            	player.sendMessage(ChatColor.YELLOW + "/pvpleave:" + ChatColor.WHITE + " Used to leave the arena");
            	player.sendMessage(ChatColor.RED + "-----");
            	return true;
            	}
			}
		/**
		 * This is the info command
		 */
			if(cmd.getName().equalsIgnoreCase("pvpinfo")){
				if(!(sender instanceof Player)){
					System.out.println("This is a player Command! sry");
					return false;
				}
				Player player = (Player) sender;
				player.sendMessage(ChatColor.YELLOW + "Name:" + ChatColor.WHITE + " SimplePvP");
				player.sendMessage(ChatColor.YELLOW + "Versiom:" + ChatColor.WHITE + version);
				player.sendMessage(ChatColor.YELLOW + "Developer:" + ChatColor.WHITE + " 7UC Ndy" );
				return true;
			    }
			/**
			 * Command that allows players to join a game!
			 * Player Commands
			 * 
			 * @args red joins red
			 *       blue joins blue
			 */
			if(cmd.getName().equalsIgnoreCase("pvpjoin")){
				if(!(sender instanceof Player)){
					System.out.println("This is a Player Command! sry");
					return true;
				}
				if(args.length == 0){
					Player player = (Player) sender;
					player.sendMessage(ChatColor.RED + "-----");
					player.sendMessage(ChatColor.WHITE + "Choose a Team " + ChatColor.BLUE + "Blue " + ChatColor.WHITE + "or " + ChatColor.RED + "Red!" );
					player.sendMessage(ChatColor.RED + "-----");
					return true;
				}
				if(args[0].equalsIgnoreCase("blue")){
					Player player = (Player) sender;
					player.sendMessage("You joined Team" + ChatColor.BLUE + " Blue");
					player.getInventory().clear();
					player.getInventory().setHelmet(new ItemStack(35, 1, Short.parseShort("0"), (byte)Short.parseShort("11")));
					player.getInventory().setChestplate(new ItemStack(299, 1));
					player.getInventory().setLeggings(new ItemStack(300, 1));
					player.getInventory().setBoots(new ItemStack(301, 1));
					player.getInventory().addItem(new ItemStack(272, 1));
					player.getInventory().addItem(new ItemStack(260, 2));
					player.setGameMode(GameMode.ADVENTURE);
					return true;
				}
				if(args[0].equalsIgnoreCase("red")){
					Player player = (Player) sender;
					player.sendMessage("You joined Team" + ChatColor.RED + " Red");
					player.getInventory().clear();
					player.getInventory().setHelmet(new ItemStack(35, 1, Short.parseShort("0"), (byte)Short.parseShort("14")));
					player.getInventory().setChestplate(new ItemStack(299, 1));
					player.getInventory().setLeggings(new ItemStack(300, 1));
					player.getInventory().setBoots(new ItemStack(301, 1));
					player.getInventory().addItem(new ItemStack(272, 1));
					player.getInventory().addItem(new ItemStack(260, 2));
					player.setGameMode(GameMode.ADVENTURE);
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("pvpleave")){
				if(!(sender instanceof Player)){
					System.out.println("This is a Player Command! sry");
					return false;
				}
				if(args.length == 0){
					Player player = (Player) sender;
					player.setGameMode(GameMode.SURVIVAL);
					player.getInventory().clear();
					player.getInventory().setHelmet(null);
					player.getInventory().setChestplate(null);
					player.getInventory().setLeggings(null);
					player.getInventory().setBoots(null);
					
					return true;
				}
			}
		return false;
	}
}

