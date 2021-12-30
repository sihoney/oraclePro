package com.javaex.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PhoneApp {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PhoneDao phoneDao = new PhoneDao();
		ArrayList<PersonVo> list;
		Object[] arr = new Object[4];
				
		System.out.println("*********************************************");
		System.out.println("*               전화 관리 프로그램               *");
		System.out.println("*********************************************");
		
		boolean active = true;
		
		while(active) {
			System.out.println();
			System.out.println("1. 리스트  2. 등록  3. 수정  4. 삭제  5. 검색  6. 종료");
			System.out.println("------------------------------------------------");
			System.out.print(">메뉴번호: ");
			
			int menu = Integer.parseInt(br.readLine());
			
			switch(menu) {
			case 1: // 리스트
				System.out.println("<1. 리스트>");
				
				list = phoneDao.selectPerson();
				
				for(PersonVo pvo : list) {
					pvo.print();
				}
				
				break;
				
			case 2: // 등록
				System.out.println("<2. 등록>");
				
				System.out.print("이름 > ");
				String name = br.readLine();
				System.out.print("휴대전화 > ");
				String hp = br.readLine();
				System.out.print("회사전화 > ");
				String compony = br.readLine();
				
				PersonVo pvo02 = new PersonVo(-1, name, hp, compony);
				phoneDao.insertPerson(pvo02);
				break;
				
			case 3: // 수정
				System.out.println("<3. 수정>");
				
				System.out.print("번호 > ");
				int personId = Integer.parseInt(br.readLine());
				System.out.print("이름 > ");
				name = br.readLine();
				System.out.print("휴대전화 > ");
				hp = br.readLine();
				System.out.print("회사전화 > ");
				compony = br.readLine();
				
				PersonVo pvo03 = new PersonVo(personId, name, hp, compony);
				phoneDao.updatePerson(pvo03);
				break;
				
			case 4: // 삭제
				System.out.println("<3. 수정>");
				
				System.out.print("번호 > ");
				personId = Integer.parseInt(br.readLine());
				
				phoneDao.deletePerson(personId);
				break;
				
			case 5: // 검색
				System.out.println("<3. 수정>");
				
				System.out.print("검색어 > ");
				String search = br.readLine();
				
				list = phoneDao.searchPerson(search);
				
				for(PersonVo pvo : list) {
					System.out.println(pvo.toString());
				}
				
				break;
				
			case 6:
				active = false;
				br.close();
				break;
				
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
		
		System.out.println("***************************************");
		System.out.println("*               감사합니다.              *");
		System.out.println("***************************************");
	}
}
