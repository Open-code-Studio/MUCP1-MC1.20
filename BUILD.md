# 构建指南

由于没有 Gradle wrapper 文件，请按照以下步骤来设置和构建项目！

## 方法1：使用 Fabric Example Mod（推荐）

### 步骤1：下载 Fabric Example Mod
1. 访问 https://github.com/FabricMC/fabric-example-mod
2. 下载最新版本（支持 Minecraft 1.20.1）

### 步骤2：替换代码
1. 解压下载的示例模组
2. 将我们项目中 `src/` 文件夹的内容复制到示例模组的 `src/` 文件夹中
3. 将我们项目的 `gradle.properties` 和 `build.gradle` 内容与示例模组的合并
4. 更新 `fabric.mod.json` 中的模组信息

### 步骤3：使用示例模组的 Gradle wrapper
示例模组已经包含完整的 `gradlew` 和 Gradle wrapper 文件！

## 方法2：手动设置 Gradle Wrapper

### 步骤1：下载 Gradle
访问 https://gradle.org/install/ 下载并安装 Gradle 8.1.1 或更高版本

### 步骤2：生成 Gradle Wrapper
在项目根目录运行：
```bash
gradle wrapper --gradle-version 8.1.1
```

### 步骤3：构建项目
```bash
./gradlew build
```

## 方法3：使用 IDE（最简单）

### 使用 IntelliJ IDEA
1. 下载安装 IntelliJ IDEA（社区版即可）
2. 安装 Minecraft Development 插件
3. 导入项目为 Gradle 项目
4. IDE 会自动处理 Gradle wrapper 的设置
5. 运行 `build` 任务

### 使用 VS Code
1. 安装 Java Extension Pack
2. 安装 Gradle for Java 插件
3. 打开项目文件夹
4. 插件会自动检测并导入项目
5. 在 Gradle 侧边栏中运行 build 任务

## 临时解决方案

如果你只是想快速测试，你可以：

1. 使用一个已经可以正常构建的 Fabric 模组作为基础
2. 将我们的源代码文件复制到那个模组的相应位置
3. 进行相应的配置修改

## 依赖说明

确保在 `build.gradle` 中有这些依赖：
- Fabric Loader 0.15.11+
- Fabric API 对应 1.20.1
- Cloth Config API 11.1.118+
- Mod Menu 7.2.2+

## 常见问题

**Q: Gradle 下载很慢？**
A: 配置国内镜像源，在 `gradle.properties` 中添加：
```properties
systemProp.https.proxyHost=...
systemProp.https.proxyPort=...
```

**Q: 找不到 Fabric 依赖？**
A: 检查 `repositories` 配置是否正确，特别是 Fabric Maven 仓库。
