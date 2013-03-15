/**
 * This is the main Class
 */
package com.andy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class SimplePvP extends JavaPlugin{
	
	private SimplePvPCommandExecutor myExecutor;
	
	@Override
	public void onEnable(){
		System.out.println("SimplePvP enabled!");
		loadConfig();
		myExecutor = new SimplePvPCommandExecutor(this);
		getCommand("pvphelp").setExecutor(myExecutor);
		myExecutor = new SimplePvPCommandExecutor(this);
		getCommand("pvpinfo").setExecutor(myExecutor);
		myExecutor = new SimplePvPCommandExecutor(this);
		getCommand("pvpjoin").setExecutor(myExecutor);
		myExecutor = new SimplePvPCommandExecutor(this);
		getCommand("pvpleave").setExecutor(myExecutor);
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
}
