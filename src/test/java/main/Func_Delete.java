package main;

import java.io.File;

import org.testng.annotations.Test;

public class Func_Delete {
	static File my_path = new File(System.getProperty("user.dir"));
	static String delete_path;

	public static void deleteAllFilesOfDir(File file) throws InterruptedException {
		if (!file.exists()) {
			System.out.println("[P]Print out >> No files!");
			return;
		}

		if (null != file) {
			if (file.isFile()) {
				boolean result = file.delete();
				int tryCount = 0;
				while (!result && tryCount++ < 10) {
					System.gc(); // return source
					Thread.sleep(2000);
					result = file.delete();
				}
			}

			File[] files = file.listFiles();

			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					deleteAllFilesOfDir(files[i]);
				}
				System.out.println("[P]Print out >> Deleted all files under " + my_path + delete_path);
			}

			file.delete();
		}
	}

	@Test
	public void test_delete_file() throws InterruptedException {
		System.out.println("[P]Print out >> Start...");
		delete_path = "\\Log\\report";
		deleteAllFilesOfDir(new File(my_path + delete_path));
		delete_path = "\\Log\\log4j";
		deleteAllFilesOfDir(new File(my_path + delete_path));
		delete_path = "\\Screenshot\\image";
		deleteAllFilesOfDir(new File(my_path + delete_path));
		delete_path = "\\Data\\compare";
		deleteAllFilesOfDir(new File(my_path + delete_path));
		delete_path = "\\Data\\IP";
		deleteAllFilesOfDir(new File(my_path + delete_path));
		delete_path = "\\Data\\info";
		deleteAllFilesOfDir(new File(my_path + delete_path));
	}
}
