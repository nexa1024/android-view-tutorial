# 01-draw-line: 在 Canvas 上画一条简单的线

预计时间：~5 分钟

## 目标

学会使用 Canvas.drawLine() 在屏幕上绘制一条线。

## 核心概念

- **Canvas**: 画布，所有绘制操作都在它上面进行
- **Paint**: 画笔，定义颜色、粗细等样式
- **onDraw()**: View 的绘制入口，重写它来自定义绘制

## 步骤

1. 创建一个自定义 View 类
2. 重写 `onDraw(canvas: Canvas)` 方法
3. 创建 Paint 对象并设置颜色
4. 调用 `canvas.drawLine()` 绘制

## drawLine 方法签名

```kotlin
fun drawLine(
    startX: Float,
    startY: Float,
    endX: Float,
    endY: Float,
    paint: Paint
)
```

## 尝试

在查看示例代码前，先自己试试：
- 从 (100f, 100f) 到 (500f, 100f) 画一条红色线
- 线的宽度设置为 10 像素

## 运行

将 LineView 添加到 Activity 的布局中，查看效果。
