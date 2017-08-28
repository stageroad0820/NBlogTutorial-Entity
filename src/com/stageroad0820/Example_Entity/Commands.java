package com.stageroad0820.Example_Entity;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main main;

	public Commands(Main plugin) {
		Commands.main = plugin;
	}

	// ChatColor 간략화
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

	// 많이 쓰이는 String 값 정리
	String prefix = ChatColor.AQUA + "[TUT] " + ChatColor.WHITE + "";
	String info = ChatColor.YELLOW + "[Info] " + ChatColor.WHITE + "";
	String error = ChatColor.DARK_RED + "[Error] " + ChatColor.RED + "";
	String warning = ChatColor.DARK_RED + "[Warning] " + ChatColor.RED + "";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Location loc = player.getLocation();
			
			if(commandLabel.equalsIgnoreCase("example") || commandLabel.equalsIgnoreCase("blog")) {
				if(args.length == 0) {
					player.sendMessage(error + "인자 값이 너무 적거나 없습니다! " + yellow + "/blog help" + red + " 를 입력해 도움말을 확인하세요.");
				}
				else {
					if(args[0].equalsIgnoreCase("help")) {
						player.sendMessage(prefix + "Example 플러그인의 도움말을 표시합니다.");
						player.sendMessage(green + "=-=-=-=-=-=-=-= Example 도움말 =-=-=-=-=-=-=-=");
						player.sendMessage(yellow + "< /example 과 /blog 두개의 커맨드로 아래의 커맨드를 똑같이 이용할 수 있습니다. > ");
						player.sendMessage(green + "/blog help : 도움말을 표시합니다.");
						player.sendMessage(green + "/blog entity <entity> : 플레이어의 위치에 입력된 엔티티를 소환합니다.");
						player.sendMessage(green + "/blog detect : 플레이어를 기준으로 모든 방향에 대해 20블록 내에 있는 모든 엔티티를 감지하여 출력합니다.");
						player.sendMessage(green + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}
					
					else if(args[0].equalsIgnoreCase("entity")) {
						if(args.length == 1) {
							player.sendMessage(error + "엔티티를 소환하기 위해서는 " + yellow + "/blog entity <entity>" 
									+ red + " 의 규칙을 지켜서 명령어를 입력해야 합니다.");
							player.sendMessage(error + "소환 가능한 엔티티 목록: " 
									+ yellow + "늑대(wolf), 오셀롯(ocelot), 주민(villager), 갑옷 거치대(armor_stand)");
						}
						else {
							if(args[1].equalsIgnoreCase("wolf")) {
								player.getWorld().spawnEntity(loc, EntityType.WOLF);
								player.sendMessage(prefix + "플레이어가 서 있는 위치에 엔티티 '늑대' 를 소환하였습니다.");
							}
							else if(args[1].equalsIgnoreCase("ocelot")) {
								player.getWorld().spawnEntity(loc, EntityType.OCELOT);
								player.sendMessage(prefix + "플레이어가 서 있는 위치에 엔티티 '오셀롯' 을 소환하였습니다.");
							}
							else if(args[1].equalsIgnoreCase("villager")) {
								player.getWorld().spawnEntity(loc, EntityType.VILLAGER);
								player.sendMessage(prefix + "플레이어가 서 있는 위치에 엔티티 '주민' 을 소환하였습니다.");
							}
							else if(args[1].equalsIgnoreCase("armor_stand")) {
								player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
								player.sendMessage(prefix + "플레이어가 서 있는 위치에 엔티티 '갑옷 거치대' 를 소환하였습니다.");
							}
						}
					}
					
					else if(args[0].equalsIgnoreCase("detect")) {
						player.sendMessage(prefix + "현재 플레이어 기준 모든 방향에 대해 20블록 내에 있는 엔티티 목록 입니다.");
						
						for(Entity entity : player.getNearbyEntities(20.0, 20.0, 20.0)) {
							player.sendMessage((entity instanceof Player ? ((Player)entity).getName() : entity.getType().name()));
							break;
						}
					}
				}
			}
		}
		
		return false;
	}
}
