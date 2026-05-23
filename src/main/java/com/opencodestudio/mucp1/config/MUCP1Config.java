package com.opencodestudio.mucp1.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "mucp1")
public class MUCP1Config implements ConfigData {
    
    @ConfigEntry.Gui.CollapsibleObject
    public DropSettings dropSettings = new DropSettings();
    
    @ConfigEntry.Gui.CollapsibleObject
    public MobSettings mobSettings = new MobSettings();
    
    @ConfigEntry.Gui.CollapsibleObject
    public BlockSettings blockSettings = new BlockSettings();
    
    @ConfigEntry.Gui.CollapsibleObject
    public CraftingSettings craftingSettings = new CraftingSettings();
    
    @ConfigEntry.Gui.CollapsibleObject
    public PortalSettings portalSettings = new PortalSettings();
    
    @ConfigEntry.Gui.CollapsibleObject
    public GravitySettings gravitySettings = new GravitySettings();
    
    @ConfigEntry.Gui.CollapsibleObject
    public TimeSettings timeSettings = new TimeSettings();
    
    @ConfigEntry.Gui.CollapsibleObject
    public SoundSettings soundSettings = new SoundSettings();
    
    public static class DropSettings {
        public boolean enableRandomDropTime = true;
        @ConfigEntry.BoundedDiscrete(min = 50, max = 300)
        public int dropTimeMinMultiplier = 50;
        @ConfigEntry.BoundedDiscrete(min = 50, max = 300)
        public int dropTimeMaxMultiplier = 300;
        
        public boolean enableQuickDespawn = true;
        @ConfigEntry.BoundedDiscrete(min = 30, max = 300)
        public int despawnTimeSeconds = 60;
        
        public boolean enableItemTeleport = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 50)
        public int teleportChancePercent = 5;
    }
    
    public static class MobSettings {
        public boolean enableMonsterBoost = true;
        @ConfigEntry.BoundedDiscrete(min = 10, max = 200)
        public int damageMultiplierPercent = 150;
        @ConfigEntry.BoundedDiscrete(min = 10, max = 200)
        public int healthMultiplierPercent = 130;
        
        public boolean enableNightIntensifier = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 5)
        public int nightMobMultiplier = 2;
        
        public boolean enableMobSpeedUp = true;
        @ConfigEntry.BoundedDiscrete(min = 10, max = 200)
        public int speedMultiplierPercent = 140;
        
        public boolean enableCreeperEnhanced = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 5)
        public float creeperExplosionPower = 3.0f;
    }
    
    public static class BlockSettings {
        public boolean enableRandomBlockHardness = true;
        @ConfigEntry.BoundedDiscrete(min = 10, max = 1000)
        public int hardnessMinMultiplier = 10;
        @ConfigEntry.BoundedDiscrete(min = 10, max = 1000)
        public int hardnessMaxMultiplier = 1000;
        
        public boolean enableDiamondLock = true;
        @ConfigEntry.BoundedDiscrete(min = 2, max = 50)
        public int diamondHardnessMultiplier = 10;
    }
    
    public static class CraftingSettings {
        public boolean enableRecipeRandomizer = false;
        public boolean enableCraftingTwist = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 50)
        public int twistChancePercent = 10;
        
        public boolean enableToolSwap = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 30)
        public int swapChancePercent = 5;
    }
    
    public static class PortalSettings {
        public boolean enablePortalChaos = true;
        @ConfigEntry.BoundedDiscrete(min = 100, max = 10000)
        public int maxTeleportDistance = 1000;
        
        public boolean enableNetherSwap = true;
        public boolean enableDimensionRandom = false;
    }
    
    public static class GravitySettings {
        public boolean enableAntiGravity = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 30)
        public int antiGravityChancePercent = 5;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 30)
        public int antiGravityDurationSeconds = 5;
        
        public boolean enableSuperGravity = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 30)
        public int superGravityChancePercent = 5;
        
        public boolean enableGravityStorm = false;
        @ConfigEntry.BoundedDiscrete(min = 5, max = 30)
        public int stormIntervalMinutes = 10;
    }
    
    public static class TimeSettings {
        public boolean enableTimeAccelerator = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 10)
        public int timeSpeedMultiplier = 2;
        
        public boolean enablePerpetualNight = false;
        
        public boolean enableRandomTimeJump = true;
        @ConfigEntry.BoundedDiscrete(min = 1, max = 30)
        public int jumpChancePercent = 3;
    }
    
    public static class SoundSettings {
        public boolean enableEerieAmbience = true;
        public boolean enableSongRandomizer = true;
        public boolean enableSoundChaos = true;
    }
}
