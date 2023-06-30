package jp.co.sss.natuyasumi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	@RequestMapping(path = "/session")
	 public String session() {
	 return "session";
	}
	
	
//	1回目（GPT）
//	// 認証を管理するためのインターフェース
//	//実際の認証処理を行うクラスがこれを実装する
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	//Springセキュリティフレームワークの一部であり、適切な設定と組み合わせて使用する必要があります。
//	//具体的な実装には、Springセキュリティの依存関係の設定、認証プロバイダーの設定、トークンリポジトリの実装などが含まれます。
//	@Autowired
//	private TokenRepository tokenRepository;
//
//	// 自動ログインを行うメソッド
//	public void autoLogin(HttpServletRequest request, HttpServletResponse response, String tokenValue) {
//	    // 自動ログイントークンをデータベースから取得
//	    Token token = tokenRepository.findByTokenValue(tokenValue);
//	    
//	    // トークンが有効であるかを確認
//	    if (token != null && !token.isExpired()) {
//	        // 自動ログイン用のユーザー情報を作成
//	    	//UserDetailsはユーザーの詳細情報を表すインターフェース
//	    	//　　具体的な実装クラスは、ユーザー名、パスワード、権限などの情報を提供する
//	        UserDetails userDetails = new User(token.getUser().getUsername(), token.getUser().getPassword(), token.getUser().getAuthorities());
//	        
//	        // 認証オブジェクトを作成
//	        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//	        
//	        // 認証を実行
//	        // Authentication 認証の結果を表すインターフェースです。
//	        //　　認証が成功した場合、認証されたユーザーの情報や権限などが含まれます。
//	        Authentication authentication = authenticationManager.authenticate(authenticationToken);
//	        
//	        // セキュリティコンテキストに認証情報をセット
//	        //セキュリティコンテキストを管理するクラスです。
//	        //認証情報を格納し、アプリケーションの他の部分でアクセスできるようにします。
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	        
//	        // 自動ログイン用のCookieを作成
//	        Cookie autoLoginCookie
	
	
//	@PostMapping
//	public void setCookie1(HttpServletResponse response) {
//	  Cookie cookie = new Cookie("key","value");
//	  cookie.setMaxAge(3600);
//	  cookie.setPath("/");
//	  response.addCookie(cookie);
//	}
//	
//	@PostMapping
//	public void setCookie(HttpServletResponse response) {
//	  ResponseCookie cookie = ResponseCookie.from("key", "value")
//	                                        .maxAge(3600)
//	                                        .path("/")
//	                                        .build();
//	  response.addHeader("Set-Cookie", cookie.toString());
//	}

	
}