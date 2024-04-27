//Without using Math.pow() function

int power(int x, long y)
        {
            if (y == 0)
                return 1;
            if (y % 2 == 0)
                return power(x, y / 2) * power(x, y / 2);

            return x * power(x, y / 2) * power(x, y / 2);
        }