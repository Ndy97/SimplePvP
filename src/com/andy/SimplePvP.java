/**
 * This is the main Class
 */
package com.andy;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;


public class SimplePvP extends JavaPlugin{
	
	private CmdExecutor MyExecutor;
	
	@Override
	public void onEnable(){
		MyExecutor = new CmdExecutor(this);
		getCommand("pvphelp").setExecutor(MyExecutor);
		MyExecutor = new CmdExecutor(this);
		getCommand("pvpinfo").setExecutor(MyExecutor);
		MyExecutor = new CmdExecutor(this);
		getCommand("pvpkit").setExecutor(MyExecutor);
		MyExecutor = new CmdExecutor(this);
		getCommand("pvpjoin").setExecutor(MyExecutor);
		MyExecutor = new CmdExecutor(this);
		getCommand("pvppos").setExecutor(MyExecutor);
		MyExecutor = new CmdExecutor(this);
		getCommand("pvpposdel").setExecutor(MyExecutor);
		
		getServer().getPluginManager().registerEvents(new BlockListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
		System.out.println("[SimplePvP]SimplePvP enabled!");
		loadConfig();
	}
	@Override
	public void onDisable(){
		System.out.println("[SimplePvP]SimplePvP shut down");
	}
	private void loadConfig(){
		if(new File("plugins/SimplePvP/config.yml").exists()){
			this.getConfig().options().copyDefaults(true);
			System.out.println("[SimplePvP] Config.yml loaded!");
		}else{
		String path1 = "configuration.FFAArena.max";
		this.getConfig().addDefault(path1, 8);
		String path2 = "configuration.Kits.Knight.Weapon";
		this.getConfig().addDefault(path2, 276);
		String path3 = "configuration.Kits.Archer.Weapon";
		this.getConfig().addDefault(path3, 261);
		String path4 = "configuration.Kits.Tank.Weapon";
		this.getConfig().addDefault(path4, 267);
		String path5 = "configuration.Kits.Medic.Weapon";
		this.getConfig().addDefault(path5, 268);
		String path6 = "configuration.Kits.Trapman.Weapon";
		this.getConfig().addDefault(path6, 272);
		String path7 = "configuration.Kits.Archer.Arrows";
		this.getConfig().addDefault(path7, 72);
		String path8 = "configuration.Kits.Archer.Armor.Helmet";
		this.getConfig().addDefault(path8, 298);
		String path9 = "configuration.Kits.Archer.Armor.Chestplate";
		this.getConfig().addDefault(path9, 299);
		String path10 = "configuration.Kits.Archer.Food.ID";
		this.getConfig().addDefault(path10, 282);
		String path11 = "configuration.Kits.Archer.Food.Amount";
		this.getConfig().addDefault(path11, 3);
		String path12 = "configuration.Kits.Archer.Armor.Boots";
		this.getConfig().addDefault(path12, 301);
		String path13 = "configuration.Kits.Archer.Armor.Leggins";
		this.getConfig().addDefault(path13, 300);
		String path14 = "configuration.Kits.Tank.Armor.Helmet";
		this.getConfig().addDefault(path14, 310);
		String path15 = "configuration.Kits.Tank.Armor.Chestplate";
		this.getConfig().addDefault(path15, 311);
		String path16 = "configuration.Kits.Tank.Armor.Leggins";
		this.getConfig().addDefault(path16, 312);
		String path17 = "configuration.Kits.Tank.Armor.Boots";
		this.getConfig().addDefault(path17, 313);
		String path18 = "configuration.Kits.Knight.Armor.Helmet";
		this.getConfig().addDefault(path18, 306);
		String path19 = "configuration.Kits.Knight.Armor.Chestplate";
		this.getConfig().addDefault(path19, 307);
		String path20 = "configuration.Kits.Knight.Armor.Leggins";
		this.getConfig().addDefault(path20, 308);
		String path21 = "configuration.Kits.Knight.Armor.Boots";
		this.getConfig().addDefault(path21, 309);
		String path22 = "configuration.Kits.Medic.Armor.Helmet";
		this.getConfig().addDefault(path22, 314);
		String path23 = "configuration.Kits.Medic.Armor.Chestplate";
		this.getConfig().addDefault(path23, 315);
		String path24 = "configuration.Kits.Medic.Armor.Leggins";
		this.getConfig().addDefault(path24, 316);
		String path25 = "configuration.Kits.Medic.Armor.Boots";
		this.getConfig().addDefault(path25, 317);
		String path26 = "configuration.Kits.Trapman.Armor.Helmet";
		this.getConfig().addDefault(path26, 302);
		String path27 = "configuration.Kits.Trapman.Armor.Chestplate";
		this.getConfig().addDefault(path27, 303);
		String path28 = "configuration.Kits.Trapman.Armor.Leggins";
		this.getConfig().addDefault(path28, 304);
		String path29 = "configuration.Kits.Trapman.Armor.Boots";
		this.getConfig().addDefault(path29, 305);
		String path30 = "configuration.Kits.Knight.Food.ID";
		this.getConfig().addDefault(path30, 282);
		String path31 = "configuration.Kits.Knight.Food.Amount";
		this.getConfig().addDefault(path31, 3);
		String path32 = "configuration.Kits.Tank.Food.ID";
		this.getConfig().addDefault(path32, 282);
		String path33 = "configuration.Kits.Tank.Food.Amount";
		this.getConfig().addDefault(path33, 3);
		String path34 = "configuration.Kits.Trapman.Food.ID";
		this.getConfig().addDefault(path34, 282);
		String path35 = "configuration.Kits.Trapman.Food.Amount";
		this.getConfig().addDefault(path35, 3);
		String path36 = "configuration.Kits.Medic.Food.ID";
		this.getConfig().addDefault(path36, 282);
		String path37 = "configuration.Kits.Medic.Food.Amount";
		this.getConfig().addDefault(path37, 3);
		String path38 = "configuration.Kits.Medic.Special.ID";
		this.getConfig().addDefault(path38, 354);
		String path39 = "configuration.Kits.Medic.Special.Amount";
		this.getConfig().addDefault(path39, 9);
		String path40 = "configuration.Kits.Trapman.Special.ID1";
		this.getConfig().addDefault(path40, 46);
		String path41 = "configuration.Kits.Trapman.Special.Amount1";
		this.getConfig().addDefault(path41, 16);
		String path42 = "configuration.Kits.Trapman.Special.ID2";
		this.getConfig().addDefault(path42, 359);
		String path43 = "configuration.Kits.Trapman.Special.Amount2";
		this.getConfig().addDefault(path43, 1);
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		System.out.println("[SimplePvP]Config loaded!");
		}
	}
}

