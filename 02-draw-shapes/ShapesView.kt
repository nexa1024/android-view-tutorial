import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ShapesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    // 填充模式的画笔
    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    // 描边模式的画笔
    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 1. 绘制填充矩形
        fillPaint.color = Color.BLUE
        canvas.drawRect(50f, 50f, 200f, 150f, fillPaint)

        // 2. 绘制描边矩形
        strokePaint.color = Color.BLUE
        canvas.drawRect(250f, 50f, 400f, 150f, strokePaint)

        // 3. 绘制填充圆形
        fillPaint.color = Color.GREEN
        canvas.drawCircle(100f, 250f, 50f, fillPaint)

        // 4. 绘制描边圆形
        strokePaint.color = Color.GREEN
        canvas.drawCircle(250f, 250f, 50f, strokePaint)

        // 5. 绘制填充椭圆
        fillPaint.color = Color.RED
        canvas.drawOval(50f, 350f, 200f, 420f, fillPaint)

        // 6. 绘制描边椭圆
        strokePaint.color = Color.RED
        canvas.drawOval(250f, 350f, 400f, 420f, strokePaint)
    }
}
