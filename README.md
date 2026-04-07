# view-tutorial

从零开始构建 Android View 系统！

<div align="center">

如果这个项目对你有帮助，请点个 **Star** 支持一下 ⭐
[https://github.com/nexa1024/android-view-tutorial](https://github.com/nexa1024/android-view-tutorial)

</div>

我一直想从最底层学习 Android View 系统是如何工作的。大多数教程只是教你如何继承现有 View 或创建简单的自定义视图，但是：

- 从未从最基础的地方开始
- 跳过了渲染工作原理的基础理解
- 没有解释为什么事情是这样运作的

受 [os-tutorial](https://github.com/cfenollosa/os-tutorial) 启发，我也想实现一个类似的lab。

## 特点

- 这是一个面向熟悉 Android 基础的开发者的代码教程
- 理论最少 — 代码优先，理解随之而来
- 课程很短，每课大约 5-15 分钟
- 每节课都建立在前一节课的基础上

## 如何使用本教程

1. 从第一个文件夹开始，按顺序学习
2. 先阅读每个文件夹中的 README
3. 在查看示例代码之前，尝试自己编写代码
4. 运行并实验代码

## 项目结构

```
android-view-tutorial/
├── app/                           # 可运行的 Android 项目
│   ├── build.gradle.kts           # app 模块构建配置
│   ├── proguard-rules.pro         # ProGuard 混淆规则
│   └── src/main/
│       ├── AndroidManifest.xml    # Android 清单文件
│       ├── java/.../viewtutorial/ # 所有课程的代码（可运行）
│       │   ├── MainActivity.kt    # 主 Activity
│       │   └── *.kt               # 各课程的自定义 View
│       └── res/                   # 资源文件
│           ├── layout/            # 布局文件
│           └── values/            # 字符串、颜色、主题等
│
├── 01-draw-line/                  # 第一课：画一条线
│   ├── README.md                  # 课程说明
│   └── LineView.kt                # 示例代码（无包名，可直接复制）
│
├── 02-draw-shapes/                # 第二课：绘制形状
│   ├── README.md
│   └── ShapesView.kt
│
├── ...                            # 其他课程文件夹
│
├── build.gradle.kts               # 项目根构建配置
├── settings.gradle.kts            # 项目设置（模块、仓库等）
├── gradle.properties              # Gradle 属性配置
├── gradle/                        # Gradle Wrapper 文件
├── .gitignore                     # Git 忽略配置
├── LICENSE                        # 许可证
└── README.md                      # 本文件
```

### 文件夹说明

| 文件夹 | 作用 |
|--------|------|
| `app/` | 完整的 Android 项目，可导入 Android Studio 直接运行 |
| `01-xxx/` | 各课程文件夹，包含 README 和示例代码 |
| `gradle/` | Gradle Wrapper，确保项目使用统一的 Gradle 版本 |
| `.claude/` | Claude Code 配置和记忆文件 |

### 课程文件夹内容

每课文件夹包含：
- `README.md` - 课程目标、核心概念、练习任务
- `*.kt` - 示例代码（不含包名，可直接复制到你的项目）

## 学习路线

我们将逐步构建 View 系统，每节课标注预计时间：

### 第一阶段：绘制基础 (20-25分钟)
- [x] 01-draw-line: 在 Canvas 上画一条简单的线 `~5min`
- [x] 02-draw-shapes: 绘制基本形状（矩形、圆形、椭圆）`~8min`
- [ ] 03-draw-text: 在 Canvas 上绘制文字 `~8min`

### 第二阶段：自定义 View (40-50分钟)
- [ ] 04-onMeasure-spec: 理解 MeasureSpec 三种模式 `~8min`
- [ ] 05-onMeasure-padding: 处理 padding 的正确测量 `~10min`
- [ ] 06-onLayout: 理解并实现 onLayout() `~8min`
- [ ] 07-draw-practice: 综合练习 - 绘制一个进度条 `~15min`

### 第三阶段：ViewGroup 基础 (60-75分钟)
- [ ] 08-view-group-skeleton: 创建最简单的 ViewGroup 骨架 `~8min`
- [ ] 09-measure-single-child: 测量单个子 View `~10min`
- [ ] 10-measure-all-children: 遍历测量所有子 View `~10min`
- [ ] 11-layout-single-child: 布局单个子 View `~10min`
- [ ] 12-layout-all-children: 布局所有子 View `~12min`
- [ ] 13-draw-children: 绘制子 View 和 dispatchDraw `~8min`
- [ ] 14-simple-layout: 综合练习 - 实现简单的流式布局 `~15min`

### 第四阶段：触摸事件 (50-60分钟)
- [ ] 15-touch-basics: onTouchEvent 和事件类型 `~8min`
- [ ] 16-touch-consumer: 让 View 成为点击的消费者 `~10min`
- [ ] 17-intercept: onInterceptTouchEvent 拦截机制 `~12min`
- [ ] 18-dispatch-down: 事件向下分发 (DOWN) `~10min`
- [ ] 19-dispatch-chain: 完整的事件链处理 `~12min`
- [ ] 20-touch-practice: 综合练习 - 可拖拽的子 View `~15min`

### 第五阶段：进阶主题 (50-65分钟)
- [ ] 21-property-animation: 基础属性动画 `~10min`
- [ ] 22-invalidate: invalidate vs requestLayout `~10min`
- [ ] 23-scroll-by: scrollBy/scrollTo 基础 `~10min`
- [ ] 24-scroll-fling: 实现惯性滚动 `~12min`
- [ ] 25-scroll-practice: 综合练习 - 可滚动的容器 `~15min`

### 第六阶段：列表与复用 (40-50分钟)
- [ ] 26-simple-list: 最基础的列表显示 `~10min`
- [ ] 27-recycle-bin: 理解 RecycleBin 复用机制 `~12min`
- [ ] 28-view-holder: ViewHolder 模式优化 `~10min`
- [ ] 29-list-practice: 综合练习 - 迷你 RecyclerView `~15min`

### 进阶选修（挑战自己）
- [ ] 30-coordinator: 自定义 CoordinatorLayout 行为
- [ ] 31-hardware-accel: 硬件加速基础知识
- [ ] 32-render-thread: RenderThread 与渲染管线

## 贡献

这是一个学习项目。欢迎提交 Issue 和 PR！
