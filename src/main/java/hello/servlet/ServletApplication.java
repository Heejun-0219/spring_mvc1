package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {
	// WAS가 실행되면서 서블릿들을 자동으로 등록해줌
	// 서블릿은 서블릿 컨테이너에 등록되어야 동작함
	// 서블릿 컨테이너는 서블릿 객체를 생성, 초기화, 호출, 종료하는 생명주기를 관리함
	// 서블릿은 싱글톤으로 관리됨
	// 서블릿 컨테이너는 동시 요청을 위한 멀티 쓰레드를 지원함
	// 서블릿은 싱글톤이기 때문에 여러 쓰레드가 동시에 접근하면 위험함
	// 동시에 접근하는 것을 막기 위해 서블릿 컨테이너는 해당 서블릿 객체의 인스턴스를 여러개 생성해서 사용함
	// 그래서 개발자가 멀티 쓰레드 환경에서 안전하게 서블릿을 개발할 수 있도록 지원함
	// 하지만 싱글톤 객체를 여러개 생성하는 것은 비효율적임
	// 그래서 서블릿은 싱글톤으로 관리하면서 멀티 쓰레드 환경에서 안전하게 개발할 수 있도록 지원함
	// 멀티 쓰레드 환경에서 싱글톤 객체를 안전하게 사용하는 방법은 여러가지가 있음
	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
