package com.mason.gmcheck;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        getCommand("gmcheck").setExecutor(new GMCheckCommand());
    }

}
