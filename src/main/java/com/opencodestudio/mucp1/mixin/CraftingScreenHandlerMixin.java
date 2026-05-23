package com.opencodestudio.mucp1.mixin;

import com.opencodestudio.mucp1.MUCP1Mod;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(CraftingScreenHandler.class)
public abstract class CraftingScreenHandlerMixin extends ScreenHandler {
    
    private static final List<ItemStack> RANDOM_ITEMS = new ArrayList<>();
    static {
        RANDOM_ITEMS.add(new ItemStack(Items.DIRT));
        RANDOM_ITEMS.add(new ItemStack(Items.COBBLESTONE));
        RANDOM_ITEMS.add(new ItemStack(Items.ROTTEN_FLESH));
        RANDOM_ITEMS.add(new ItemStack(Items.BONE));
        RANDOM_ITEMS.add(new ItemStack(Items.SPIDER_EYE));
        RANDOM_ITEMS.add(new ItemStack(Items.POISONOUS_POTATO));
        RANDOM_ITEMS.add(new ItemStack(Items.CACTUS));
        RANDOM_ITEMS.add(new ItemStack(Items.GRAVEL));
        RANDOM_ITEMS.add(new ItemStack(Items.SAND));
        RANDOM_ITEMS.add(new ItemStack(Items.GUNPOWDER));
    }
    
    protected CraftingScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }
    
    @Inject(method = "updateResult", at = @At("HEAD"))
    private static void onUpdateResult(ScreenHandler handler, CraftingInventory inventory, CallbackInfo ci) {
        if (MUCP1Mod.CONFIG.craftingSettings.enableCraftingTwist) {
            int chance = MUCP1Mod.CONFIG.craftingSettings.twistChancePercent;
            if (MUCP1Mod.RANDOM.nextInt(100) < chance) {
            }
        }
    }
}
