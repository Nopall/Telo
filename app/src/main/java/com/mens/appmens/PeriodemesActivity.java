package com.mens.appmens;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.mens.appmens.model.PeriodsMens;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeriodemesActivity extends AppCompatActivity {
    private static final String TAG = PeriodemesActivity.class.getSimpleName();
    @BindView(R.id.calendarview)
    MaterialCalendarView calendarView;
    @BindView(R.id.btn_tambahperiod)
    Button btn_tambahperiod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodemes);
        ButterKnife.bind(this);

        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());

        Log.d(TAG, "onCreate: " + calendarView.getSelectedDates());
    }

    public class EventDecorator implements DayViewDecorator {

        private final int color;
        private final HashSet<CalendarDay> dates;

        public EventDecorator(int color, Collection<CalendarDay> dates) {
            this.color = color;
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new DotSpan(5, color));
        }
    }

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -2);
            Log.d(TAG, "doInBackground: " + calendar);
            ArrayList<CalendarDay> dates = new ArrayList<>();
//            for (int i = 0; i < 30; i++) {
//                CalendarDay day = CalendarDay.from(calendar);
//                dates.add(day);
//                calendar.add(Calendar.DATE, 5);
//            }
            dates.add(CalendarDay.from(2017,9,2));
            dates.add(CalendarDay.from(2017,9,3));
            dates.add(CalendarDay.from(2017,9,4));

            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }

            Log.d(TAG, "onPostExecute: " + calendarDays);

            calendarView.addDecorator(new EventDecorator(Color.RED, calendarDays));
        }
    }
}
