# 02-draw-shapes: 绘制基本形状

预计时间：~8 分钟

## 目标

学会在 Canvas 上绘制矩形、圆形和椭圆。

## 核心概念

- **drawRect()**: 绘制矩形或圆角矩形
- **drawCircle()**: 绘制圆形
- **drawOval()**: 绘制椭圆
- **Paint.Style**: 填充(FILL)与描边(STROKE)模式

## 方法签名

```kotlin
// 矩形
fun drawRect(left: Float, top: Float, right: Float, bottom: Float, paint: Paint)

// 圆形
fun drawCircle(cx: Float, cy: Float, radius: Float, paint: Paint)

// 椭圆
fun drawOval(left: Float, top: Float, right: Float, bottom: Float, paint: Paint)
```

## Paint.Style

- `Paint.Style.FILL` - 填充形状内部（默认）
- `Paint.Style.STROKE` - 仅绘制边框
- `Paint.Style.FILL_AND_STROKE` - 同时填充和描边

## DashPathEffect - 虚线效果

```kotlin
DashPathEffect(floatArrayOf(intervals...), phase)
```

### 第一个参数：intervals 数组
定义**实线-空白**交替的长度模式：

```kotlin
floatArrayOf(16f, 4f)
//        ↑    ↑
//     实线  空白
//     16px   4px
```

效果：`━━━━  ━━━━  ━━━━  ━━━━`

可以是更多值形成复杂模式：
```kotlin
floatArrayOf(20f, 5f, 5f, 5f)
//  长实线 短空 短实线 短空
// 效果：═══     ═     ═     ═
```

### 第二个参数：phase
定义虚线的**起始偏移量**：

```kotlin
DashPathEffect(floatArrayOf(16f, 4f), 0f)   // 从实线开始
// ━━━━━━━━━━━━━━    ━━━━━━━━━━━━━━

DashPathEffect(floatArrayOf(16f, 4f), 8f)   // 偏移8px，从实线中间开始
//    ━━━━━━━━━━━━━       ━━━━━━━━━━━━━

DashPathEffect(floatArrayOf(16f, 4f), 16f)  // 偏移16px，从空白开始
//         ━━━━━━━━━━━━━         ━━━━━━━━━━━━━
```

**动画用法**：连续改变 phase 值可实现"蚂蚁线"流动效果。

### 使用示例

```kotlin
val dashPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = Paint.Style.STROKE
    strokeWidth = 8f
    pathEffect = DashPathEffect(floatArrayOf(16f, 4f), 0f)
}
canvas.drawRect(left, top, right, bottom, dashPaint)
```

## 尝试

在查看示例代码前，先自己试试：
- 绘制一个蓝色矩形（左上角 50,50，右下角 200,150）
- 绘制一个绿色圆形（圆心 300,100，半径 50）
- 绘制一个橙色椭圆（外接矩形 400,50 到 550,150）

## 运行

将 ShapesView 添加到 Activity 的布局中，查看效果。
