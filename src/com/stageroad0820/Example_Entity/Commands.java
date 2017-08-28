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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Location loc = player.getLocation();
			
			if(commandLabel.equalsIgnoreCase("example") || commandLabel.equalsIgnoreCase("blog")) {
				if(args.length == 0) {
					player.sendMessage(error + "���� ���� �ʹ� ���ų� �����ϴ�! " + yellow + "/blog help" + red + " �� �Է��� ������ Ȯ���ϼ���.");
				}
				else {
					if(args[0].equalsIgnoreCase("help")) {
						player.sendMessage(prefix + "Example �÷������� ������ ǥ���մϴ�.");
						player.sendMessage(green + "=-=-=-=-=-=-=-= Example ���� =-=-=-=-=-=-=-=");
						player.sendMessage(yellow + "< /example �� /blog �ΰ��� Ŀ�ǵ�� �Ʒ��� Ŀ�ǵ带 �Ȱ��� �̿��� �� �ֽ��ϴ�. > ");
						player.sendMessage(green + "/blog help : ������ ǥ���մϴ�.");
						player.sendMessage(green + "/blog entity <entity> : �÷��̾��� ��ġ�� �Էµ� ��ƼƼ�� ��ȯ�մϴ�.");
						player.sendMessage(green + "/blog detect : �÷��̾ �������� ��� ���⿡ ���� 20��� ���� �ִ� ��� ��ƼƼ�� �����Ͽ� ����մϴ�.");
						player.sendMessage(green + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}
					
					else if(args[0].equalsIgnoreCase("entity")) {
						if(args.length == 1) {
							player.sendMessage(error + "��ƼƼ�� ��ȯ�ϱ� ���ؼ��� " + yellow + "/blog entity <entity>" 
									+ red + " �� ��Ģ�� ���Ѽ� ��ɾ �Է��ؾ� �մϴ�.");
							player.sendMessage(error + "��ȯ ������ ��ƼƼ ���: " 
									+ yellow + "����(wolf), ������(ocelot), �ֹ�(villager), ���� ��ġ��(armor_stand)");
						}
						else {
							if(args[1].equalsIgnoreCase("wolf")) {
								player.getWorld().spawnEntity(loc, EntityType.WOLF);
								player.sendMessage(prefix + "�÷��̾ �� �ִ� ��ġ�� ��ƼƼ '����' �� ��ȯ�Ͽ����ϴ�.");
							}
							else if(args[1].equalsIgnoreCase("ocelot")) {
								player.getWorld().spawnEntity(loc, EntityType.OCELOT);
								player.sendMessage(prefix + "�÷��̾ �� �ִ� ��ġ�� ��ƼƼ '������' �� ��ȯ�Ͽ����ϴ�.");
							}
							else if(args[1].equalsIgnoreCase("villager")) {
								player.getWorld().spawnEntity(loc, EntityType.VILLAGER);
								player.sendMessage(prefix + "�÷��̾ �� �ִ� ��ġ�� ��ƼƼ '�ֹ�' �� ��ȯ�Ͽ����ϴ�.");
							}
							else if(args[1].equalsIgnoreCase("armor_stand")) {
								player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
								player.sendMessage(prefix + "�÷��̾ �� �ִ� ��ġ�� ��ƼƼ '���� ��ġ��' �� ��ȯ�Ͽ����ϴ�.");
							}
						}
					}
					
					else if(args[0].equalsIgnoreCase("detect")) {
						player.sendMessage(prefix + "���� �÷��̾� ���� ��� ���⿡ ���� 20��� ���� �ִ� ��ƼƼ ��� �Դϴ�.");
						
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
