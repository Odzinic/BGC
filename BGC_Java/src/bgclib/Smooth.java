package bgclib;

import classes.Constant;

import java.util.ArrayList;
import java.util.List;


public class Smooth {

    public int run_avg(final List<Double> input, List<Double> output, int n, int w, int w_flag) {

		/*
         * calculates running averages n = length of input and output arrays w =
		 * width of averaging window w_flag : 1=linearly weighted window,
		 * 0=constant weighted window
		 */

        int i, j;
        int ok = 1;
        List<Integer> wt = new ArrayList<Integer>();
        double total, sum;

        String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

        if (w > n) {
            System.out.printf(BV_ERROR, "Error: averaging window longer than input array\n");
            ok = 0;
        }

        // if (ok && (!(wt = (int*) malloc(w * sizeof(int)))))
        // {
        // System.out.printf(BV_ERROR, "Allocation error in boxcar_smooth...
        // Exiting\n");
        // ok=0;
        // }

        if (ok == 1) {
            if (w_flag == 1)
                for (i = 0; i < w; i++)
                    wt.add(i, i + 1);
            else
                for (i = 0; i < w; i++)
                    wt.add(i, 1);

            for (i = 0; i < n; i++) {
                total = 0.0;
                sum = 0.0;
                if (i < (w - 1)) {
                    for (j = w - i - 1; j < w; j++) {
                        total += (double) wt.get(j) * input.get(i - w + j + 1);
                        sum += (double) wt.get(j);
                    }
                } else {
                    for (j = 0; j < w; j++) {
                        total += (double) wt.get(j) * input.get(i - w + j + 1);
                        sum += (double) wt.get(j);
                    }
                }
                output.add(i, total / sum);

            } /* end for i=nelements */

            // free(wt);
        }
        return 0;
    }

    public int boxcar_smooth(List<Double> input, List<Double> output, int n, int w, int w_flag) {

        int ok = 1;
        int tail = 0, i, j;
        List<Integer> wt = new ArrayList<Integer>();
        double total, sum;

        String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

		/* establish the lengths of the boxcar tails */
        if (ok == 1) {
            if ((w % 2) == 0)
                w += 1;
            tail = w / 2;
        }

        if (ok == 1) {
            System.out.printf(BV_ERROR, "Allocation error in boxcar_smooth... Exiting\n");
            ok = 0;
        }

		/*
		 * when w_flag != 0, use linear ramp to weight tails, otherwise use
		 * constant weight
		 */
        if (ok == 1) {
            if (w_flag == 1) {
                for (i = 0; i < tail; i++)
                    wt.add(i, i + 1);
                for (i = 0; i <= tail; i++)
                    wt.add((i + tail), tail + 1 - i);
            } else
                for (i = 0; i < w; i++)
                    wt.add(i, 1);

            for (i = 0; i < n; i++) {
                total = 0.0;
                sum = 0.0;
                if (i < tail) {
                    for (j = tail - i; j < w; j++) {
                        total += input.get(i + j - tail) * wt.get(j);
                        sum += (double) wt.get(j);
                    }
                } else if ((i >= tail) && (i < n - tail)) {
                    for (j = 0; j < w; j++) {
                        total += input.get(i + j - tail) * wt.get(j);
                        sum += (double) wt.get(j);
                    }
                } else if (i >= n - tail) {
                    for (j = 0; j < tail + n - i; j++) {
                        total += input.get(i + j - tail) * wt.get(j);
                        sum += (double) wt.get(j);
                    }
                }
                output.add(i, total / sum);

            } /* end for i=nelements */

        } /* end if ok */

        return 0;
    }

}
