# 完整项目设置指南

## 🏗️ 最简单的方法：使用 Fabric 官方模板

### 步骤1：使用 Fabric 模组生成器

1. 访问 **https://fabricmc.net/develop/template/**
2. 填写以下信息：
   - Minecraft Version: `1.20.1`
   - Mod Name: `使你不会玩1`
   - Mod ID: `mucp1`
   - Package Name: `com.opencodestudio.mucp1`
3. 点击 "Generate" 下载完整的项目模板

### 步骤2：替换代码

下载后，将我们项目中的以下文件复制到模板项目中：

**替换/复制文件：**
```
src/main/java/com/opencodestudio/mucp1/
  MUCP1Mod.java
  config/
    MUCP1Config.java
    MUCP1ModMenu.java
  mixin/
    EntityItemMixin.java
    LivingEntityMixin.java
    BlockMixin.java
    CraftingScreenHandlerMixin.java
    PortalMixin.java
    PlayerMixin.java
    ServerWorldMixin.java
    SoundSystemMixin.java

src/main/resources/
  fabric.mod.json
  mucp1.mixins.json
  assets/mucp1/
    lang/
      zh_cn.json
      en_us.json
```

**更新以下文件：**
- `build.gradle` - 添加我们的依赖项
- `gradle.properties` - 使用我们的配置

### 步骤3：构建！

现在你有完整的 Gradle wrapper，可以直接运行：
```bash
./gradlew build
```

---

## 📦 依赖列表

确保你的 `build.gradle` 包含这些：

```groovy
dependencies {
    // Fabric API
    modImplementation "net.fabricmc.fabric-api:fabric-api:${project.fabric_version}"
    
    // Cloth Config
    modImplementation "me.shedaniel.cloth:cloth-config-fabric:11.1.118"
    include "me.shedaniel.cloth:cloth-config-fabric:11.1.118"
    
    // Mod Menu
    modImplementation "com.terraformersmc:modmenu:7.2.2"
}
```

---

## 🔧 完整的 fabric.mod.json

```json
{
  "schemaVersion": 1,
  "id": "mucp1",
  "version": "1.0.0",
  "name": "使你不会玩1-我的世界1.20",
  "description": "一个充满捣乱、陷阱和挑战的Minecraft 1.20模组！",
  "authors": [
    "Open Code Studio"
  ],
  "contact": {
    "homepage": "https://github.com/Open-code-Studio/MUCP1-MC1.20",
    "sources": "https://github.com/Open-code-Studio/MUCP1-MC1.20"
  },
  "license": "MIT",
  "icon": "assets/mucp1/icon.png",
  "environment": "*",
  "entrypoints": {
    "main": [
      "com.opencodestudio.mucp1.MUCP1Mod"
    ],
    "modmenu": [
      "com.opencodestudio.mucp1.config.MUCP1ModMenu"
    ]
  },
  "mixins": [
    "mucp1.mixins.json"
  ],
  "depends": {
    "fabricloader": ">=0.15.11",
    "minecraft": "~1.20.1",
    "java": ">=17",
    "fabric-api": "*",
    "cloth-config": "*"
  },
  "suggests": {
    "modmenu": "*"
  }
}
```

---

## 📋 项目文件清单

现在这个项目包含：
✅ 完整的源代码
✅ 配置系统
✅ 本地化文件
✅ Mixin 配置
✅ Gradle 构建脚本
✅ 设置指南和文档

---

## 🚀 下一步

1. 使用 Fabric 模板生成器获取完整项目
2. 复制我们的源代码
3. 运行 `./gradlew build` 构建
4. 将生成的 JAR 放入 mods 文件夹
5. 开始游戏！

祝你的模组开发愉快！🎮🔥
