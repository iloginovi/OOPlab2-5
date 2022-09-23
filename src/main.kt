fun printList(listListFigures: Collection<List<ColoredShape2d>>) {
    if (listListFigures.isNotEmpty()) {
        for (i in listListFigures) {
            println(i)
        }
        println("")
    }
}

fun printListFigures(listFigures: List<ColoredShape2d>) {
    for (i in listFigures) {
        println(i)
    }
}

fun main() {
    val figures = ShapeCollector<ColoredShape2d>()
    figures.addFigure(Circle(2.0, Color(2, 2, 2), Color(3, 3))) //добавление фигуры
    var listListFigures = figures.getListDifferentFigure() //возвращение фигуры (списком)
    println("Figure:")
    printList(listListFigures.values) //вывод списка
    println("Key:")
    print(listListFigures.keys)
    println("")
    println("")
    figures.addFigure(Square(2.0, Color(2, 2, 2), Color(3)))
    figures.addFigure(Rectangle(2.0, 3.0, Color(2, 2, 2), Color(3, 3)))//добавление новых фигур
    figures.addFigure(Triangle(2.0, 3.0, 2.0, Color(2, 0, 2), Color(3))) // в уже существующий список
    listListFigures = figures.getListDifferentFigure() //возвращает список фигур
    println("Figures:")
    printList(listListFigures.values)
    println("Keys:")
    println(listListFigures.keys)
    println("")
    println("Smallest area:")
    println(figures.getFigureSmallest()) //фигура с наименьшей площадью
    println("Largest area:")
    println(figures.getFigureLargest()) //фигура с наибольшей площадью
    println("Sum of all areas ${figures.getSumArea()}") //сумма всех площадей
    println("Search by border color:")
    printListFigures(figures.findBorderColor(Color(2, 2, 0)))
    printListFigures(figures.findBorderColor(Color(2, 2, 2))) //поиск по цвету границы
    println("")
    println("Search by fill color:")
    printListFigures(figures.findFillColor(Color(3, 2)))
    printListFigures(figures.findFillColor(Color(3, 3)))//поиск по цвету заливки
    println("")
    println("List of figures:")
    printListFigures(figures.getListFigure())
    println("")
    println("Number of figures ${figures.getCountFigure()}")
    println("")
    println("Group by border color:")
    figures.getBorderFigure(Color(2, 0, 2))[Color(2, 0, 2)]?.let { printListFigures(it) } //группиовка по цвету границы
    println("")
    println("Group by fill color:")
    figures.getFillFigure(Color(3, 3))[Color(3, 3)]?.let { printListFigures(it) } //группировка по цвету залливки
    println("")
    println("Sorted figures:")
    println(figures.getSorted(FigureComparator())) //отсортированные фигуры
    println("")
    figures.addAll(listOf(Circle(1.0, Color(), Color()))) //добавление списка фигур к сущетсвующим
    println("Add list:")
    println(figures.getListFigure())
}