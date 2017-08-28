package com.stageroad0820.Example_Entity;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.stageroad0820.Example_Entity.Events.Event_EntityByEntity;

public class Main extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;

	PluginDescriptionFile pdfFile = this.getDescription();
	PluginManager pm = Bukkit.getServer().getPluginManager();

	// ChatColor ����ȭ
	String aqua = ChatColor.AQUA + "";
	String black = ChatColor.BLACK + "";
	String blue = ChatColor.BLUE + "";
	String daqua = ChatColor.DARK_AQUA + "";
	String dblue = ChatColor.DARK_BLUE + "";
	String dgray = ChatColor.DARK_GRAY + "";
	String dgreen = ChatColor.DARK_GREEN + "";
	String dpurple = ChatColor.DARK_PURPLE + "";
	String dred = ChatColor.DARK_RED + "";
	String gold = ChatColor.GOLD + "";
	String gray = ChatColor.GRAY + "";
	String green = ChatColor.GREEN + "";
	String lpurple = ChatColor.LIGHT_PURPLE + "";
	String red = ChatColor.RED + "";
	String white = ChatColor.WHITE + "";
	String yellow = ChatColor.YELLOW + "";

	String bold = ChatColor.BOLD + "";
	String italic = ChatColor.ITALIC + "";
	String magic = ChatColor.MAGIC + "";
	String reset = ChatColor.RESET + "";
	String strth = ChatColor.STRIKETHROUGH + "";
	String under = ChatColor.UNDERLINE + "";

	// ���� ���̴� String �� ����
	String prefix = ChatColor.AQUA + "[TUT] " + ChatColor.WHITE + "";
	String info = ChatColor.YELLOW + "[Info] " + ChatColor.WHITE + "";
	String error = ChatColor.DARK_RED + "[Error] " + ChatColor.RED + "";
	String warning = ChatColor.DARK_RED + "[Warning] " + ChatColor.RED + "";
	String plname = ChatColor.GREEN + pdfFile.getName() + "";
	String plvers = ChatColor.GREEN + pdfFile.getVersion() + "";
	String pname = plname + " v" + plvers + " ";
	String cinfo = info + ChatColor.YELLOW + pname + ChatColor.WHITE + " ";

	@Override
	public void onEnable() {
		getCommand("blog").setExecutor(new Commands(this));
		getCommand("example").setExecutor(new Commands(this));
		console(prefix + yellow + "/blog �� /example " + white + " ��ɾ ��ϵǾ����ϴ�.");
		
		pm.registerEvents(new Event_EntityByEntity(this), this);
		console(prefix + yellow + "EntityDamageByEntityEvent " + white + " �̺�Ʈ�� ��ϵǾ����ϴ�.");
		
		console(prefix + pname + " (��)�� Ȱ��ȭ �Ǿ����ϴ�!");
		super.onEnable();
	}

	@Override
	public void onDisable() {

		console(prefix + pname + " (��)�� ��Ȱ��ȭ �Ǿ����ϴ�!");
		super.onDisable();
	}
	
	public static void console(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}
}
