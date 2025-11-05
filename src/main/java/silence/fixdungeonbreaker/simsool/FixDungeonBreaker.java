package silence.fixdungeonbreaker.simsool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import silence.fixdungeonbreaker.simsool.commands.ToggleCommand;
import silence.fixdungeonbreaker.simsool.utils.ItemUtils;

@Mod(modid = "fixdungeonbreaker", name = "Fix DungeonBreaker", version = "1.0.0", clientSideOnly = true)
public class FixDungeonBreaker {

	public static boolean ENABLED = true;
	public static Minecraft mc = Minecraft.getMinecraft();

	private final Set<Block> IGNORED_BLOCKS = new HashSet<>(Arrays.asList(
			Blocks.chest,
			Blocks.trapped_chest,
			Blocks.lever,
			Blocks.skull,
			Blocks.redstone_block
	));
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		ClientCommandHandler.instance.registerCommand(new ToggleCommand());
	}

	@SubscribeEvent
	public void onBreakSpeed(PlayerEvent.BreakSpeed event) {
		if (ENABLED) {
			ItemStack item = event.entityPlayer.getHeldItem(); if (item == null) return;
			if (ItemUtils.getItemID(item).equals("DUNGEONBREAKER")) {
				if (IGNORED_BLOCKS.contains(event.state.getBlock())) return;
				event.newSpeed = 1024.0F;
			}
		}
	}

}
