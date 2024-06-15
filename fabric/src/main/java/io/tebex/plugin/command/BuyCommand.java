package io.tebex.plugin.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.tebex.plugin.TebexPlugin;
import io.tebex.plugin.gui.BuyGUI;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class BuyCommand {
    private final TebexPlugin plugin;
    public BuyCommand(TebexPlugin plugin) {
        this.plugin = plugin;
    }

    public int execute(CommandContext<ServerCommandSource> context) {
        final ServerCommandSource source = context.getSource();
        if (!source.isExecutedByPlayer()) {
            source.sendMessage(Text.of("§b[Tebex] §7You must be a player to run this command!"));
            return Command.SINGLE_SUCCESS;
        }

        ServerPlayerEntity player = source.getPlayer();
        new BuyGUI(plugin).open(player);

        return Command.SINGLE_SUCCESS;
    }
}
