package controller;

import controller_board.BoardViewController;
import controller_board.DeleteBoardController;
import controller_board.InsertBoardController;
import controller_board.InsertCommentController;
import controller_board.UpdateBoardViewController;
import controller_board.UpdateCommentLikeHateController;
import controller_board.UpdateLikeHateController;
import controller_board.WriteBoardViewController;
import controller_member.InsertMemberController;
import controller_member.LoginController;
import controller_member.LogoutController;
import controller_member.ManageDeleteMemberController;
import controller_member.ManageSearchMemberController;
import controller_member.ManageUpdateMemberController;
import controller_member.MemberManageController;
import controller_member.UpdateMemberController;
import controller_member.UpdateViewController;
import controller_qna.InsertQnaController;
import controller_qna.NextQnaListController;
import controller_qna.QnaMasterViewController;
import controller_qna.QnaViewController;
import controller_qna.UpdateQnaResponseController;

public class HandlerMapping {
	
	private static HandlerMapping instance = new HandlerMapping();
	
	private HandlerMapping() {
		
	}
	
	public static HandlerMapping getInstance() {
		if(instance == null) instance = new HandlerMapping();
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "main.do":
			controller = new MainController();
			break;
		case "login.do":
			controller = new LoginController();
			break;
		case "logout.do":
			controller = new LogoutController();
			break;
		case "register_member.do":
			controller = new InsertMemberController();
			break;
		case "update_view.do":
			controller = new UpdateViewController();
			break;
		case "update_member.do":
			controller = new UpdateMemberController();
			break;
		case "register_qna.do":
			controller = new InsertQnaController();
			break;
		case "qna_view.do":
			controller = new QnaViewController();
			break;
		case "next_qnaList.do":
			controller = new NextQnaListController();
			break;
		case "qna_master_view.do":
			controller = new QnaMasterViewController();
			break;
		case "update_qna_response.do":
			controller = new UpdateQnaResponseController();
			break;
		case "write_board_view.do":
			controller = new WriteBoardViewController();
			break;
		case "insert_board.do":
			controller = new InsertBoardController();
			break;
		case "delete_board.do":
			controller = new DeleteBoardController();
			break;
		case "update_board_view.do":
			controller = new UpdateBoardViewController();
			break;
		case "board_view.do":
			controller = new BoardViewController();
			break;
		case "update_like_hate.do":
			controller = new UpdateLikeHateController();
			break;
		case "update_comment_like_hate.do":
			controller = new UpdateCommentLikeHateController();
			break;
		case "image_load.do":
			controller = new ImageLoadController();
			break;
		case "insert_comment.do":
			controller = new InsertCommentController();
			break;
		case "member_manage.do":
			controller = new MemberManageController();
			break;
		case "manage_search_member.do":
			controller = new ManageSearchMemberController();
			break;
		case "manage_update_member.do":
			controller = new ManageUpdateMemberController();
			break;
		case "manage_delete_member.do":
			controller = new ManageDeleteMemberController();
			break;
		}
		return controller;
	}
}
