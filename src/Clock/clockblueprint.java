package Clock;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class clockblueprint extends JFrame {

	// 現在の時間と日付を取得
	Calendar calendar;
	// 書式表記
	SimpleDateFormat timeFormat;
	// 日付用の書式を用意
	SimpleDateFormat dayFormat;
	// ラベル表記
	JLabel label;
	// 取得した時間を文字列にする
	String time;
	// 日付をラベルする
	JLabel dayLabel;
	String day;

	public clockblueprint() {
		// ウィンドウを閉じたらプログラムを終了する
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		// ウィンドウのサイズ
		this.setSize(350, 200);
		// サイズ変更
		this.setResizable(true);
		// タイトル設定
		this.setTitle("Clock");
		// ウィンドウを表示
		this.setVisible(true);

		// 時間表記
		this.timeFormat = new SimpleDateFormat("HH:mm:ss");

		// 日付表記
		dayFormat = new SimpleDateFormat("MM/dd");

		// ラベル作成及び初期化
		this.label = new JLabel();
		label.setFont(new Font("Arial", Font.PLAIN, 50));
		label.setForeground(Color.green);
		label.setBackground(Color.black);
		label.setOpaque(true);

		this.dayLabel = new JLabel();
		dayLabel.setFont(new Font("Arial", Font.PLAIN, 20));

		// ウィンドウに日付と時間を表記
		this.add(label);
		this.add(dayLabel);

		// 時間が動くフィールドを持つ設計にする
		setTime();
	}

	// 時間が動くクラス
	public void setTime() {
		// 時間取得し、ラベルに追加することを繰り返す。
		while (true) {
			// カレンダーで取得した現在時間を書式化
			time = timeFormat.format(calendar.getInstance().getTime());
			// 取得し、書式化した時間をラベルに追加。
			label.setText(time);

			// カレンダーで取得した現在の日付を書式化
			day = dayFormat.format(calendar.getInstance().getTime());
			// 取得し、書式化した日付をラベルに追加。
			dayLabel.setText(day);
		}
	}
}
