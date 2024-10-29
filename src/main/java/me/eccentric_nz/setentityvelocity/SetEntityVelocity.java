package me.eccentric_nz.setentityvelocity;

import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SetEntityVelocity extends JavaPlugin {

    public String pluginName;
    private ArmorStand stand = null;

    @Override
    public void onDisable() {
        this.stand = null;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        PluginDescriptionFile pdfFile = getDescription();
        pluginName = ChatColor.GOLD + "[" + pdfFile.getName() + "]" + ChatColor.RESET + " ";
        pm.registerEvents(new SetEntityVelocityListener(this), this);
        getCommand("setentityvelocity").setExecutor(new SetEntityVelocityCommand(this));
    }

    public void setStand(ArmorStand stand) {
        this.stand = stand;
    }

    public ArmorStand getStand() {
        return stand;
    }
}