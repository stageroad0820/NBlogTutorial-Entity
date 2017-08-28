package com.stageroad0820.Example_Entity.Events;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.stageroad0820.Example_Entity.Main;

public class Event_EntityByEntity implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main example;

	public Event_EntityByEntity(Main plugin) {
		Event_EntityByEntity.example = plugin;
	}

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
	
	@EventHandler
	public void onEntityDamaged(EntityDamageByEntityEvent event) {
		Entity entity = event.getEntity();
		Entity damager = event.getDamager();
		
		double dm_take = ((LivingEntity) entity).getLastDamage();
		double dm_give = event.getDamage();
		
		if(damager instanceof Player) {
			String victim = entity.getName();
			String attacker = damager.getName();
			
			damager.sendMessage(prefix + yellow + victim + white + " (��)�� " + yellow + attacker + white + " ���� " 
					+ red + dm_take + white + " ��ŭ�� �������� �Ծ����ϴ�!");
		}
		else if (damager instanceof Arrow) {
			Arrow arrow = (Arrow) damager;
			LivingEntity shooter = (LivingEntity) arrow.getShooter();
			
			String victim = entity.getName();
			String attacker = shooter.getName();
			
			shooter.sendMessage(prefix + yellow + attacker + white + " (��)�� " + yellow + victim + white + " ���� "
					+ red + dm_give + white + " ��ŭ�� �������� �־����ϴ�!");
		}
		else {
			Player player = (Player) entity;
			
			String victim = entity.getName();
			String attacker = damager.getName();
			
			player.sendMessage(prefix + yellow + attacker + white + " (��)�� " + yellow + victim + white + " ���� "
					+ red + dm_give + white + " ��ŭ�� �������� �־����ϴ�!");
		}
	}
}
