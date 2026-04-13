import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class TextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textSize = 48f
        textAlign = Paint.Align.LEFT
    }

    private val fontMetrics = Paint.FontMetrics()

    // 预分配 Paint 对象，避免在 onDraw 中分配
    private val boxPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#E8F5E9")
        style = Paint.Style.FILL
    }

    private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(76, 175, 80)
        style = Paint.Style.STROKE
        strokeWidth = 2f
    }

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 2f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val baseline = 100f
        val startX = 50f

        // 1. 基础文字绘制 - 默认黑色、左对齐
        textPaint.apply {
            color = Color.BLACK
            textAlign = Paint.Align.LEFT
            textSize = 48f
            typeface = Typeface.DEFAULT
        }
        canvas.drawText("Hello View!", startX, baseline, textPaint)

        // 2. 红色文字、居中对齐
        textPaint.apply {
            color = Color.RED
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("Centered", 200f, baseline + 80f, textPaint)

        // 3. 蓝色文字、右对齐
        textPaint.apply {
            color = Color.BLUE
            textAlign = Paint.Align.RIGHT
        }
        canvas.drawText("Right Align", 350f, baseline + 160f, textPaint)

        // 4. 粗体文字
        textPaint.apply {
            color = Color.DKGRAY
            textAlign = Paint.Align.LEFT
            typeface = Typeface.DEFAULT_BOLD
        }
        canvas.drawText("Bold Text", startX, baseline + 240f, textPaint)

        // 5. 斜体文字
        textPaint.apply {
            color = Color.MAGENTA
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
        }
        canvas.drawText("Italic Text", startX, baseline + 320f, textPaint)

        // 6. 使用 FontMetrics 垂直居中文字
        textPaint.apply {
            color = Color.rgb(76, 175, 80)  // 绿色
            textSize = 56f
            textAlign = Paint.Align.CENTER
            typeface = Typeface.DEFAULT_BOLD
        }

        // 获取字体度量
        textPaint.getFontMetrics(fontMetrics)
        val text = "Vertical Center"
        val centerX = width / 2f
        val centerY = height / 2f

        // 计算垂直居中的基线位置
        // 基线 = 中心Y - (ascent + descent) / 2
        // 或者：基线 = 中心Y + (ascent + descent) / 2 的负值
        val baselineY = centerY - (fontMetrics.ascent + fontMetrics.descent) / 2

        // 绘制背景框
        val boxTop = baselineY + fontMetrics.top
        val boxBottom = baselineY + fontMetrics.bottom
        canvas.drawRect(centerX - 150f, boxTop, centerX + 150f, boxBottom, boxPaint)

        // 绘制边框
        canvas.drawRect(centerX - 150f, boxTop, centerX + 150f, boxBottom, borderPaint)

        // 绘制文字
        canvas.drawText(text, centerX, baselineY, textPaint)

        // 7. 绘制 FontMetrics 参考线（展示度量值）
        val refX = 50f
        val refBaseline = 500f

        // 获取小字体的度量
        textPaint.textSize = 32f
        textPaint.getFontMetrics(fontMetrics)

        // 绘制基线
        linePaint.color = Color.BLACK
        canvas.drawLine(refX, refBaseline, refX + 200f, refBaseline, linePaint)

        // 绘制 top 线
        linePaint.color = Color.RED
        canvas.drawLine(refX, refBaseline + fontMetrics.top, refX + 200f, refBaseline + fontMetrics.top, linePaint)

        // 绘制 ascent 线
        linePaint.color = Color.parseColor("#FF9800")
        canvas.drawLine(refX, refBaseline + fontMetrics.ascent, refX + 200f, refBaseline + fontMetrics.ascent, linePaint)

        // 绘制 descent 线
        linePaint.color = Color.parseColor("#2196F3")
        canvas.drawLine(refX, refBaseline + fontMetrics.descent, refX + 200f, refBaseline + fontMetrics.descent, linePaint)

        // 绘制 bottom 线
        linePaint.color = Color.parseColor("#9C27B0")
        canvas.drawLine(refX, refBaseline + fontMetrics.bottom, refX + 200f, refBaseline + fontMetrics.bottom, linePaint)

        // 绘制标注文字
        textPaint.textSize = 20f
        textPaint.textAlign = Paint.Align.LEFT
        canvas.drawText("FontMetrics", refX, refBaseline - 80f, Color.BLACK)

        textPaint.color = Color.RED
        canvas.drawText("top", refX + 210f, refBaseline + fontMetrics.top + 5f, textPaint)

        textPaint.color = Color.parseColor("#FF9800")
        canvas.drawText("ascent", refX + 210f, refBaseline + fontMetrics.ascent + 5f, textPaint)

        textPaint.color = Color.BLACK
        canvas.drawText("baseline", refX + 210f, refBaseline + 5f, textPaint)

        textPaint.color = Color.parseColor("#2196F3")
        canvas.drawText("descent", refX + 210f, refBaseline + fontMetrics.descent + 5f, textPaint)

        textPaint.color = Color.parseColor("#9C27B0")
        canvas.drawText("bottom", refX + 210f, refBaseline + fontMetrics.bottom + 5f, textPaint)
    }

    // 辅助方法：用指定颜色绘制文字
    private fun Canvas.drawText(text: String, x: Float, y: Float, color: Int) {
        textPaint.color = color
        this.drawText(text, x, y, textPaint)
    }
}
