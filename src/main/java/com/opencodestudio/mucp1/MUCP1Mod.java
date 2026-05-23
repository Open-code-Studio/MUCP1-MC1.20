package com.opencodestudio.mucp1;

import com.opencodestudio.mucp1.config.MUCP1Config;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class MUCP1Mod implements ModInitializer {
    public static final String MOD_ID = "mucp1";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Random RANDOM = new Random();
    public static MUCP1Config CONFIG;
    
    private static int gravityStormTimer = 0;
    private static boolean gravityStormActive = false;
    
    @Override
    public void onInitialize() {
        LOGGER.info("🎮 正在初始化 '使你不会玩1-我的世界1.20' 模组...");
        
        AutoConfig.register(MUCP1Config.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MUCP1Config.class).getConfig();
        
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            handleGravityStorm(server);
        });
        
        LOGGER.info("🎭 '使你不会玩1-我的世界1.20' 模组初始化完成！准备好接受挑战吧！");
    }
    
    private void handleGravityStorm(net.minecraft.server.MinecraftServer server) {
        if (!CONFIG.gravitySettings.enableGravityStorm) return;
        
        gravityStormTimer++;
        int stormIntervalTicks = CONFIG.gravitySettings.stormIntervalMinutes * 60 * 20;
        
        if (gravityStormTimer >= stormIntervalTicks && !gravityStormActive) {
            startGravityStorm(server);
            gravityStormTimer = 0;
            gravityStormActive = true;
        } else if (gravityStormActive && gravityStormTimer >= 20 * 30) {
            endGravityStorm(server);
            gravityStormTimer = 0;
            gravityStormActive = false;
        }
    }
    
    private void startGravityStorm(net.minecraft.server.MinecraftServer server) {
        server.getPlayerManager().broadcast(
            Text.literal("⚠️ 重力风暴来袭！准备好体验混乱吧！").formatted(Formatting.RED),
            false
        );
    }
    
    private void endGravityStorm(net.minecraft.server.MinecraftServer server) {
        server.getPlayerManager().broadcast(
            Text.literal("✅ 重力风暴已结束...暂时安全了！").formatted(Formatting.GREEN),
            false
        );
    }
    
    public static boolean isGravityStormActive() {
        return gravityStormActive;
    }
}
