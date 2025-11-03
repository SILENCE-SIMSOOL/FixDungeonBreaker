package silence.fixdungeonbreaker.simsool.commands;

import static silence.fixdungeonbreaker.simsool.FixDungeonBreaker.mc;
import java.util.Collections;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import silence.fixdungeonbreaker.simsool.FixDungeonBreaker;

public class ToggleCommand extends CommandBase {

	@Override
	public String getCommandName() {
		return "fixdungeonbreaker";
	}

	@Override
	public List<String> getCommandAliases() {
		return Collections.singletonList("fdb");
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/" + getCommandName();
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		FixDungeonBreaker.ENABLED = !FixDungeonBreaker.ENABLED;
		String enabled = FixDungeonBreaker.ENABLED ? "¡×aENABLED" : "¡×cDISABLED";
		sender.addChatMessage(new ChatComponentText("¡×7Dungeon Breaker: " + enabled));
	}

}