# 快速开始指南

## 📋 要求

- **Minecraft Java Edition** 1.20.1
- **Java 17** 或更高版本
- **Fabric Loader** 0.15.11 或更高版本

## 🔨 构建模组

1. **克隆或下载项目**
   ```bash
   cd /path/to/MUCP1-MC1.20
   ```

2. **使用 Gradle 构建**
   - **Windows**: `gradlew.bat build`
   - **Linux/Mac**: `./gradlew build`

3. **找到编译好的模组**
   编译好的 JAR 文件位于：`build/libs/mucp1-mc1.20-1.0.0.jar`

## 🎮 安装步骤

1. **安装 Fabric Loader**
   - 前往 https://fabricmc.net/use/ 下载安装器
   - 运行安装器，选择 Minecraft 1.20.1 和最新的 Fabric Loader

2. **安装 Fabric API**
   - 下载与 Minecraft 1.20.1 兼容的 Fabric API：https://modrinth.com/mod/fabric-api
   - 将 Fabric API JAR 放入 `.minecraft/mods/` 文件夹

3. **安装本模组**
   - 将编译好的 `mucp1-mc1.20-1.0.0.jar` 放入 `.minecraft/mods/` 文件夹

4. **安装 Cloth Config（可选但推荐）**
   - 下载 Cloth Config API：https://modrinth.com/mod/cloth-config
   - 下载 Mod Menu：https://modrinth.com/mod/modmenu
   - 这两个模组可以让你在游戏内调整配置

5. **启动游戏！**

## ⚙️ 配置说明

所有功能都可以通过配置文件调整！

### 方法1：游戏内配置（推荐）
- 安装 Mod Menu 和 Cloth Config
- 在游戏主菜单点击 "Mods"
- 找到 "使你不会玩1-我的世界1.20"
- 点击配置按钮进行调整

### 方法2：手动编辑配置
- 配置文件位置：`.minecraft/config/mucp1.json`
- 可以直接编辑此文件来调整各项参数

## 📜 已实现的功能

### ✅ 掉落物捣乱
- 随机掉落时间
- 快速消失
- 物品随机传送

### ✅ 怪物强化
- 增加伤害
- 增加生命值
- 增加移动速度
- 爬行者强化

### ✅ 方块硬度变化
- 随机方块硬度
- 钻石矿超难挖

### ✅ 合成混乱
- 合成结果扭曲
- 工具功能交换

### ✅ 传送混乱
- 传送门随机目的地

### ✅ 重力异常
- 反重力（随机飘浮）
- 超重（跳不高）
- 重力风暴（定时混乱）

### ✅ 时间异常
- 时间加速
- 永恒夜晚
- 随机时间跳跃

### ✅ 音效混乱
- 怪异氛围音
- 音乐随机化
- 声音混乱

## 🎯 游戏建议

1. **备份存档！** 这个模组可能会让你的世界变得很疯狂！
2. **先从简单模式开始** 逐步增加难度
3. **多人游戏更有趣** 和朋友一起体验混乱吧
4. **录制视频** 记录你的精彩瞬间

## 📞 遇到问题？

- 检查 Minecraft 和 Java 版本是否正确
- 确保所有依赖模组都已安装
- 查看日志文件获取更多信息

享受混乱的乐趣吧！🎮🔥
