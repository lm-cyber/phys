package library.collision;

import library.dynamics.Body;
import library.math.Vectors2D;

/**
 * Axis aligned bounding box volume class. Allows the creation of bounding volumes to make broad phase collision check possible and easy to do.
 * Класс объема ограничительной рамки, выровненный по оси. Позволяет создавать ограничивающие объемы, чтобы сделать проверку широкополосного столкновения возможной и простой в выполнении.
 */
public class AABB {
    /**
     * Lower left vertex of bounding box.
     * Нижняя левая вершина ограничивающей рамки.
     */
    private Vectors2D min;
    /**
     * Top right vertex of bounding box.
     * Верхняя правая вершина ограничивающего прямоугольника
     */
    private Vectors2D max;

    /**
     * Constructor to generate an AABB given a minimum and maximum bound in the form of two vectors.
     *
     * Конструктор для генерации AABB с заданной минимальной и максимальной границей в виде двух векторов.
     * @param min Lower bound of AABB vertex.
     * @param max Higher bound of AABB vertex.
     * Нижняя граница вершины AABB.
     * Более высокая граница вершины AABB
     */
    public AABB(Vectors2D min, Vectors2D max) {
        this.min = min.copy();
        this.max = max.copy();
    }

    /**
     * Default constructor generating an AABB with (0,0) upper and lower bounds.
     * Конструктор по умолчанию, генерирующий AABB с верхней и нижней границами (0,0).
     */
    public AABB() {
        this.min = new Vectors2D();
        this.max = new Vectors2D();
    }

    /**
     * Sets the current objects bounds equal to that of the passed AABB argument.
     * Устанавливает границы текущих объектов равными границам переданного аргумента AABB.
     * @param aabb An AABB bounding box.
     * Ограничивающая рамка AABB.
     */
    public final void set(final AABB aabb) {
        Vectors2D v = aabb.min;
        min.x = v.x;
        min.y = v.y;
        Vectors2D v1 = aabb.max;
        max.x = v1.x;
        max.y = v1.y;
    }

    /**
     * Getter for min variable for lower bound vertex.
     * Геттер для минимальной переменной для нижней границы вершины.
     * @return AABB min
     */
    public Vectors2D getMin() {
        return min;
    }

    /**
     * Getter for max variable for upper bound vertex.
     * Средство получения максимальной переменной для вершины с верхней границей.
     * @return AABB max
     */
    public Vectors2D getMax() {
        return max;
    }

    /**
     * Method to check if an AABB is valid.
     * Способ проверки того, является ли AABB действительным.
     * Makes sure the bounding volume is not; a point, has order of vertex's backwards and valid values have been used for the bounds.
     * Убедитесь, что ограничивающий объем не является точкой, имеет обратный порядок вершин и для границ были использованы допустимые значения.
     * @return boolean value of the validity of the AABB.
     * логическое значение допустимости AABB
     */
    public final boolean isValid() {
        if (max.x - min.x < 0) {
            return false;
        }
        if (max.y - min.y < 0) {
            return false;
        }
        return min.isValid() && max.isValid();
    }

    /**
     * Method to check if a point resides inside an AABB in object space.
     * Метод проверки того, находится ли точка внутри AABB в пространстве объектов.
     * @param point A point to check if its inside the AABB's object space. Point needs to also be in object space.
     * точку, чтобы проверить, находится ли она внутри объектного пространства AABB. Точка также должна находиться в пространстве объектов.
     * @return Boolean value whether or not the point lies inside the AABB bounds.
     * Логическое значение независимо от того, находится точка внутри границ AABB или нет.
     */
    public boolean AABBOverLap(Vectors2D point) {
        double x = point.x;
        double y = point.y;
        return x <= this.getMax().x && x >= this.getMin().x && y >= this.getMax().y && y <= this.getMin().y;
    }

    /**
     * Method to add offset to the AABB's bounds. Can be useful to convert from object to world space .
     * Способ добавления смещения к границам AABB. Может быть полезно для преобразования из объекта в мировое пространство .
     *
     * @param offset A vector to apply to the min and max vectors to translate the bounds and therefore AABB to desired position.
     * Вектор для применения к векторам min и max для перевода границ и, следовательно, AABB в желаемое положение.
     */
    public void addOffset(Vectors2D offset) {
        this.min.add(offset);
        this.max.add(offset);
    }

    @Override
    public final String toString() {
        return "AABB[" + min + " . " + max + "]";
    }

    /**
     * Copy method to return a new AABB that's the same as the current object.
     * Метод копирования для возврата нового AABB, который совпадает с текущим объектом.
     * @return New AABB that's the same as the current object.
     * это то же самое, что и текущий объект.
     */
    public AABB copy() {
        return new AABB(this.min, this.max);
    }

    /**
     * Checks whether two body's AABB's overlap in world space.
     * Проверяет, перекрываются ли AABB двух тел в мировом пространстве.
     * @param A First body to evaluate.
     * @param B Second body to evaluate.
     * @return Boolean value of whether the two bodies AABB's overlap in world space.
     * Первый орган для оценки.
     * Второй орган для оценки.
     * Логическое значение того, перекрываются ли два тела AABB в мировом пространстве.
     */
    public static boolean AABBOverLap(Body A, Body B) {
        AABB aCopy = A.aabb.copy();
        AABB bCopy = B.aabb.copy();

        aCopy.addOffset(A.position);
        bCopy.addOffset(B.position);

        return AABB.AABBOverLap(aCopy, bCopy);
    }

    /**
     * Method to check if two AABB's overlap. Can be seen as world space.
     * Способ проверки того, перекрываются ли два Aabb. Можно рассматривать как мировое пространство.
     * @param a First AABB to evaluate.
     * @param b Second AABB to evaluate.
     * @return Boolean value of whether two bounds of the AABB's overlap.
     * Первый AABB для оценки.
     * Второй AABB для оценки.
     * Логическое значение того, перекрываются ли две границы AABB.
     */
    public static boolean AABBOverLap(AABB a, AABB b) {
        return a.min.x <= b.max.x &&
                a.max.x >= b.min.x &&
                a.min.y <= b.max.y &&
                a.max.y >= b.min.y;
    }
}
