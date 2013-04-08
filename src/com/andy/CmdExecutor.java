package com.andy;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CmdExecutor implements CommandExecutor{
	
	public SimplePvP plugin;
	
	public CmdExecutor(SimplePvP plugin){
		plugin = this.plugin;
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("pvphelp")){
			if(player.hasPermission("simplepvp.help")){
			if(!(sender instanceof Player)){
				System.out.println("This is a player Command! sry");
	            return false;
			}
			if (args.length == 0){
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
            	player.sendMessage(ChatColor.RED + "-----");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin lobby:" + ChatColor.WHITE + " Used to join the " + ChatColor.BLACK + "Lobby");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin red:" + ChatColor.WHITE + " Used to join Team " + ChatColor.RED + "Red");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin blue:" + ChatColor.WHITE + " Used to join Team " + ChatColor.BLUE + "Blue");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin green:" + ChatColor.WHITE + " Used to join Team " + ChatColor.GREEN + "Green");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin yellow:" + ChatColor.WHITE + " Used to join Team " + ChatColor.YELLOW + "Yellow");
            	player.sendMessage(ChatColor.YELLOW + "/pvpjoin yellow:" + ChatColor.WHITE + " Used to join the " + ChatColor.BLACK + "FFA-Arena");
            	player.sendMessage(ChatColor.YELLOW + "/pvpleave <exit>:" + ChatColor.WHITE + " Used to leave the Arena");
            	player.sendMessage(ChatColor.YELLOW + "/pvpleave <spectate>:" + ChatColor.WHITE + " Used to spectate the Arena");
            	player.sendMessage(ChatColor.RED + "-----");
            	return true;
            	}
            if (args[0].equalsIgnoreCase("admin")){
            	player.sendMessage(ChatColor.RED + "-----");
            	player.sendMessage(ChatColor.YELLOW + "/pvppos: " + ChatColor.WHITE + "Used to set the positions for a Arena.");
            	player.sendMessage(ChatColor.YELLOW + "  usage: " + ChatColor.WHITE + "/pvppos <red|blue|green|yellow|exit|specate|lobby|ffa 1-8>");
            	player.sendMessage(ChatColor.YELLOW + "/pvpposdel: " + ChatColor.WHITE + "Used to delete the Positions.");
            	player.sendMessage(ChatColor.RED + "-----");
            	return true;
            	}
			}
		}
		if(cmd.getName().equalsIgnoreCase("pvpinfo")){
			if(player.hasPermission("simplepvp.info")){
			if(!(sender instanceof Player)){
				System.out.println("This is a player Command! sry");
				return false;
			}
			player.sendMessage(ChatColor.YELLOW + "Name:" + ChatColor.WHITE + " SimplePvP");
			player.sendMessage(ChatColor.YELLOW + "Version:" + ChatColor.WHITE + "v1.9");
			player.sendMessage(ChatColor.YELLOW + "Developer:" + ChatColor.WHITE + " 7UC Ndy" );
			return true;
		    }
		}
		if(cmd.getName().equalsIgnoreCase("pvpjoin")){
			if(!(sender instanceof Player)){
				System.out.println("This is a Player Command! sry");
				return false;
			}
			if(player.hasPermission("simplepvp.join")){
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "-----");
				player.sendMessage(ChatColor.WHITE + "Choose a Team!");
				player.sendMessage(ChatColor.RED + "-----");
				return true;
				}
			if(args[0].equalsIgnoreCase("lobby")){
				try{
					Location loc = (Location) plugin.getConfig().get("locations." + args[0].toLowerCase());
					player.teleport(loc);
					player.sendMessage("You joined the Lobby!");
					player.sendMessage("Use /pvpleave <exit> to leave the Lobby!");
					player.getInventory().clear();
					player.getInventory().setHelmet(null);
					player.getInventory().setChestplate(null);
					player.getInventory().setLeggings(null);
					player.getInventory().setBoots(null);
					player.teleport(loc);
					player.setGameMode(GameMode.ADVENTURE);
					return true;
				}catch (Exception e){
					player.sendMessage(ChatColor.RED + "You cannot join the Lobby!");
					return false;
				}
			}
			if(args[0].equalsIgnoreCase("blue")){
				try{
					Location loc = (Location) plugin.getConfig().get("locations." + args[0].toLowerCase());
					player.teleport(loc);
					player.sendMessage("You joined Team" + ChatColor.BLUE + " Blue");
					player.sendMessage("Use /pvpleave <exit> to leave the Arena!");
					player.getInventory().setHelmet(new ItemStack(35, 1, Short.parseShort("0"), (byte)Short.parseShort("11")));
					return true;
				}catch (Exception e){
					player.sendMessage(ChatColor.RED + "You cannot join the blue Team!");
					return false;
				}
			}
			if(args[0].equalsIgnoreCase("yellow")){
				try{
					Location loc = (Location) plugin.getConfig().get("locations." + args[0].toLowerCase());
					player.teleport(loc);
					player.sendMessage("You joined Team" + ChatColor.YELLOW + " Yellow");
					player.sendMessage("Use /pvpleave <exit> to leave the Arena!");
					player.getInventory().setHelmet(new ItemStack(35, 1, Short.parseShort("0"), (byte)Short.parseShort("4")));
					return true;
				}catch (Exception e){
					player.sendMessage(ChatColor.RED + "You cannot join the yellow Team!");
					return false;
				}
			}
			if(args[0].equalsIgnoreCase("green")){
				try{
					Location loc = (Location) plugin.getConfig().get("locations." + args[0].toLowerCase());
					player.teleport(loc);
					player.sendMessage("You joined Team" + ChatColor.GREEN+ " Green");
					player.sendMessage("Use /pvpleave <exit> to leave the Arena!");
					player.getInventory().setHelmet(new ItemStack(35, 1, Short.parseShort("0"), (byte)Short.parseShort("5")));
					return true;
				}catch (Exception e){
					player.sendMessage(ChatColor.RED + "You cannot join the grren Team!");
					return false;
				}
			}
			if(args[0].equalsIgnoreCase("red")){
				try{
					Location loc = (Location) plugin.getConfig().get("locations." + args[0].toLowerCase());
					player.teleport(loc);
					player.sendMessage("You joined Team" + ChatColor.RED + " Red");
					player.sendMessage("Use /pvpleave <exit> to leave the Arena!");
					player.getInventory().setHelmet(new ItemStack(35, 1, Short.parseShort("0"), (byte)Short.parseShort("14")));;
					return true;
				}catch (Exception e){
					player.sendMessage(ChatColor.RED + "You cannot join the red Team!");
					return false;
				}
			}
			if(args[0].equalsIgnoreCase("ffa")){
				args[0] = args[0] + RandomNum(plugin.getConfig().getInt("configuration.FFAArena.max"), 1);
				try{
					Location loc = (Location) plugin.getConfig().get("locations." + args[0].toLowerCase());
					player.teleport(loc);
					player.sendMessage("You joined the " + ChatColor.BLACK + "FFA-Arena!");
					player.sendMessage("Use /pvpleave <exit> to leave the Arena!");
					return true;
				}catch(Exception e){
					player.sendMessage("You can not join the FFA-Arena!");
					return false;
				}
			}
			}
		}
		if(cmd.getName().equalsIgnoreCase("pvppos")){
			if(player.hasPermission("simplepvp.admin")){
				if(!(sender instanceof Player)){
					System.out.println("This is a player Command! sry");
					return false;
					}
				if(args.length != 1){
					player.sendMessage(ChatColor.YELLOW + "Command:");
					player.sendMessage(ChatColor.YELLOW + "/pvppos <spectate|red|blue|green|yellow|exit|lobby|ffa 1-8> !");
					return false;
				}
				if(!(plugin.getConfig().contains("locations." + args[0].toLowerCase()))){
					Location loc = player.getLocation();
				
					plugin.getConfig().set("locations." + args[0].toLowerCase(), loc);
					plugin.saveConfig();
					player.sendMessage(ChatColor.YELLOW + "SimplePvP Location " + ChatColor.WHITE + args[0] + ChatColor.YELLOW + " set!");
					return true;
				}else{
					player.sendMessage(ChatColor.RED + "Position already set!");
					return false;
			}
		}	
	}
		if(cmd.getName().equalsIgnoreCase("pvpposdel")){
			if(player.hasPermission("simplepvp.admin")){
				if(args.length != 1){
					player.sendMessage("You need a position to delete!");
					return false;
				}
				if(!(sender instanceof Player)){
					System.out.println("This is a player Command! sry");
					return false;
				}
				try{
					plugin.getConfig().set("locations." + args[0].toLowerCase(), null);
					plugin.saveConfig();
					player.sendMessage(ChatColor.YELLOW + "Position " + ChatColor.WHITE + args[0] + ChatColor.YELLOW + " deleted!");
					
					return true;
				}catch (Exception e){
					player.sendMessage(ChatColor.RED + "You can not delete" + args[0]);
					return false;
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("pvpkit")){
			if(!(sender instanceof Player)){
				System.out.println("This is a player Command sry!");
				return false;
			}
			if(player.hasPermission("simplepvp.kit")){
				if(args.length == 0){
					player.sendMessage(ChatColor.YELLOW + "Choose a kit" + ChatColor.AQUA + " Archer, Tank, Knight, Medic or Trapman!");
					return false;
				}
				if(args[0].equalsIgnoreCase("Archer")){
					player.getInventory().addItem(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Food.ID"), plugin.getConfig().getInt("configuration.Kits.Archer.Food.Amount")));
					player.getInventory().addItem(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Weapon"), 1));
					player.getInventory().addItem(new ItemStack(262, plugin.getConfig().getInt("configuration.Kits.Archer.Arrows")));
					player.getInventory().setHelmet(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Helmet"), 1));
					player.getInventory().setChestplate(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Chestplate"), 1));
					player.getInventory().setLeggings(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Leggins"), 1));
					player.getInventory().setBoots(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Boots"), 1));
					player.sendMessage(ChatColor.YELLOW + "You choosed the kit " + ChatColor.AQUA + "Archer!");
					return true;
				}
				if(args[0].equalsIgnoreCase("Medic")){
					player.sendMessage(ChatColor.YELLOW + "You choosed the kit " + ChatColor.AQUA + "Medic!");
					return true;
				}
				if(args[0].equalsIgnoreCase("Tank")){
					player.getInventory().addItem(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Food.ID"), plugin.getConfig().getInt("configuration.Kits.Archer.Food.Amount")));
					player.getInventory().addItem(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Weapon"), 1));
					player.getInventory().addItem(new ItemStack(262, plugin.getConfig().getInt("configuration.Kits.Archer.Arrows")));
					player.getInventory().setHelmet(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Helmet"), 1));
					player.getInventory().setChestplate(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Chestplate"), 1));
					player.getInventory().setLeggings(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Leggins"), 1));
					player.getInventory().setBoots(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Armor.Boots"), 1));
					player.sendMessage(ChatColor.YELLOW + "You choosed the kit " + ChatColor.AQUA + "Tank!");
					return true;
				}
				if(args[0].equalsIgnoreCase("Knight")){
					player.getInventory().addItem(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Knight.Food.ID"), plugin.getConfig().getInt("configuration.Kits.Knight.Food.Amount")));
					player.getInventory().addItem(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Knight.Weapon"), 1));
					player.getInventory().setHelmet(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Archer.Knight.Helmet"), 1));
					player.getInventory().setChestplate(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Knight.Armor.Chestplate"), 1));
					player.getInventory().setLeggings(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Knight.Armor.Leggins"), 1));
					player.getInventory().setBoots(new ItemStack(plugin.getConfig().getInt("configuration.Kits.Knight.Armor.Boots"), 1));
					player.sendMessage(ChatColor.YELLOW + "You choosed the kit " + ChatColor.AQUA + "Knight!");
					return true;
				}
				if(args[0].equalsIgnoreCase("Trapman")){
					player.sendMessage(ChatColor.YELLOW + "You choosed the kit " + ChatColor.AQUA + "Trapman!");
					return true;
				}
			}
		}
		return false;
	}
	public static int RandomNum(int high, int low) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}
}
