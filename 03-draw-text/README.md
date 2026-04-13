# 03-draw-text: 在 Canvas 上绘制文字

预计时间：~8 分钟

<div align="center">

如果这个项目对你有帮助，请点个 **Star** 支持一下 ⭐
[https://github.com/nexa1024/android-view-tutorial](https://github.com/nexa1024/android-view-tutorial)

</div>

## 目标

学会使用 Canvas.drawText() 在屏幕上绘制文字，并控制字体大小、颜色和对齐方式。

## 核心概念

- **drawText()**: 绘制文字的主要方法
- **Paint.textSize**: 设置文字大小（单位：像素）
- **Paint.textAlign**: 设置文字对齐方式
- **Paint.color**: 设置文字颜色
- **Paint.typeface**: 设置字体样式（粗体、斜体等）

## 方法签名

```kotlin
// 基础绘制方法
fun drawText(text: String, x: Float, y: Float, paint: Paint)

// 绘制指定范围的文字
fun drawText(text: String, start: Int, end: Int, x: Float, y: Float, paint: Paint)

// 沿路径绘制文字
fun drawTextOnPath(text: String, path: Path, hOffset: Float, vOffset: Float, paint: Paint)
```

## Paint.TextAlign 对齐方式

坐标 `(x, y)` 的含义根据对齐方式而变化：

| 对齐方式 | x 坐标含义 | 示例 |
|---------|-----------|------|
| `LEFT` | 文字左边界 | `Text____` |
| `CENTER` | 文字中心 | `__Text__` |
| `RIGHT` | 文字右边界 | `____Text` |

**注意**：`y` 坐标始终是文字**基线**（baseline）的位置，不是顶部！

```
      ┃ 文字顶部
      ┃
══════╋═════ ← 基线 (y坐标所在位置)
      ┃
      ┃ 下沉部（如 g、p、q 的尾巴）
```

## Paint.FontMetrics - 字体度量

用于精确计算文字位置：

```kotlin
paint.getFontMetrics(fontMetrics)

// 主要属性
fontMetrics.top       // 字体顶部到基线的距离（负值）
fontMetrics.ascent    // 字符顶部到基线的距离（负值）
fontMetrics.descent   // 字符底部到基线的距离（正值）
fontMetrics.bottom    // 字体底部到基线的距离（正值）
fontMetrics.leading   // 行间距（正值）
```

计算文字高度：
```kotlin
val textHeight = fontMetrics.descent - fontMetrics.ascent
```

## Typeface 字体样式

```kotlin
// 默认字体
typeface = Typeface.DEFAULT

// 粗体
typeface = Typeface.DEFAULT_BOLD

// 斜体
typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)

// 粗斜体
typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC)

// 等宽字体
typeface = Typeface.MONOSPACE

// 衬线字体
typeface = Typeface.SERIF

// 无衬线字体
typeface = Typeface.SANS_SERIF
```

## 尝试

在查看示例代码前，先自己试试：
- 在 (100, 100) 位置绘制红色文字 "Hello View!"
- 设置文字大小为 48sp
- 使用 CENTER 对齐方式

## 运行

将 TextView 添加到 Activity 的布局中，查看效果。
