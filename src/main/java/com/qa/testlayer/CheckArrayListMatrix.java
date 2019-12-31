/**
 * 
 */
package com.qa.testlayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author Manohar
 * 
 */
public class CheckArrayListMatrix {

	public static void main(String args[]) throws IOException {

		ReadExcelDataToArrayList();
		// ListOfIntergerArray();
		// InetgerArray();
		// StringArray();

	}

	public static void ReadExcelDataToArrayList() throws IOException {
		String filename = "E:\\Manohar24\\Manohar\\Java_Projects\\workspace3\\ResourcesN\\DataN\\MasterData.xls";

		List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0);

			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();

				List data = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					data.add(cell);
				}

				sheetData.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

		showExelData(sheetData);
	}

	public static void showExelData(List sheetData) {
		//
		// Iterates the data and print it out to the console.
		//
		for (int i = 0; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) {
				HSSFCell cell = (HSSFCell) list.get(j);
				System.out.print(cell.getRichStringCellValue().getString());
				if (j < list.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("");
		}
	}

	public static void ListOfIntergerArray() {

		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(2);
		triangle.add(row1);

		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(3);
		row2.add(4);
		triangle.add(row2);

		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		System.out.println("Size = " + triangle.size());
		for (int i = 0; i < triangle.size(); i++)
			System.out.println(triangle.get(i));

	}

	public static void StringArray() {
		List<ArrayList<String>> a = new ArrayList<ArrayList<String>>();

		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();

		a1.add("11");
		a1.add("22");
		a1.add("33");

		a2.add("44");
		a2.add("55");
		a2.add("66");

		a3.add("77");
		a3.add("88");
		a3.add("99");

		a.add(a1);
		a.add(a2);
		a.add(a3);

		for (ArrayList<String> obj : a) {

			ArrayList<String> temp = obj;

			for (String job : temp) {
				System.out.print(job + " ");
			}
			System.out.println();
		}
	}

	public static void InetgerArray() {
		List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();

		a1.add(1);
		a1.add(2);
		a1.add(3);

		a2.add(4);
		a2.add(5);
		a2.add(6);

		a3.add(7);
		a3.add(8);
		a3.add(9);

		a.add(a1);
		a.add(a2);
		a.add(a3);

		for (ArrayList<Integer> obj : a) {

			ArrayList<Integer> temp = obj;

			for (Integer job : temp) {
				System.out.print(job + " ");
			}
			System.out.println();
		}
	}

}
