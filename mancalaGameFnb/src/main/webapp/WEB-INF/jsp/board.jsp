<%--suppress HtmlRequiredAltAttribute --%>
<%--Renders game board--%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link rel="stylesheet" href="Semantic-UI/semantic.min.css">
<link rel="stylesheet" href="Semantic-UI/components/accordion.min.css">
<script src="Semantic-UI/jquery3.2.0.js"></script>
<script src="Semantic-UI/semantic.min.js"></script>
<script src="Semantic-UI/components/accordion.min.js"></script>
<script language='javascript'>
	$(document).ready(function() {
		$('.ui.accordion').accordion();
	});
</script>
</head>
<spring:url value="resources/css/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />

<body>
	<div class="ui equal width left aligned padded grid"
		style="margin: 0 auto">
		<div class="row">
			<div class="black column">
				<h1 class="ui center aligned header orange">Welcome to Mancala
					Game</h1>
			</div>
		</div>
		<div class="row" style="background-color: #00965e">
			<div class="column">
				<div class="ui inverted segment">
					<div class="ui inverted accordion">
						<div class="title">
							<i class="dropdown icon"></i> Rules
						</div>
						<div class="content">
							<p class="transition hidden"><u>Game Play</u><br> The player who begins
								with the first move picks up all the stones in any of his own
								six pits, and sows the stones on to the right, one in each of
								the following pits, including his own big pit. No stones are put
								in the opponents' big pit. If the player's last stone lands in
								his own big pit, he gets another turn. This can be repeated
								several times before it's the other player's turn.<br> 
								<u>Capturing</u><br>
								Stones During the game the pits are emptied on both sides.
								Always when the last stone lands in an own empty pit, the player
								captures his own stone and all stones in the opposite pit (the
								other player's pit) and puts them in his own (big or little?)
								pit.<br> 
								<u>The Game Ends</u><br>
								 The game is over as soon as one of the sides
								runs out of stones. The player who still has stones in his pits
								keeps them and puts them in his big pit. The winner of the game
								is the player who has the most stones in his big pit.</p>
						</div>
					</div>
				</div>
			</div>

			<div class="column">
				<table>
					<tr>
						<%-- player one score --%>
						<td>
							<div class="pit middle">${pitStones[0]}</div> <img
							src="resources/images/leftScore.jpg" />
						</td>

						<%-- main board --%>
						<td>
							<table>
								<tr>
									<td><a href="${pageContext.request.contextPath}/input/1"><img
											src="resources/images/topBoard.jpg" />
											<div class="pit top">${pitStones[1]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/2"><img
											src="resources/images/topBoard.jpg" />
											<div class="pit top">${pitStones[2]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/3"><img
											src="resources/images/topBoard.jpg" />
											<div class="pit top">${pitStones[3]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/4"><img
											src="resources/images/topBoard.jpg" />
											<div class="pit top">${pitStones[4]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/5"><img
											src="resources/images/topBoard.jpg" />
											<div class="pit top">${pitStones[5]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/6"><img
											src="resources/images/topBoard.jpg" />
											<div class="pit top">${pitStones[6]}</div> </a></td>
								</tr>
								<tr>
									<td><a href="${pageContext.request.contextPath}/input/13"><img
											src="resources/images/bottomBoard.jpg" />
											<div class="pit bottom">${pitStones[13]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/12"><img
											src="resources/images/bottomBoard.jpg" />
											<div class="pit bottom">${pitStones[12]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/11"><img
											src="resources/images/bottomBoard.jpg" />
											<div class="pit bottom">${pitStones[11]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/10"><img
											src="resources/images/bottomBoard.jpg" />
											<div class="pit bottom">${pitStones[10]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/9"><img
											src="resources/images/bottomBoard.jpg" />
											<div class="pit bottom">${pitStones[9]}</div> </a></td>
									<td><a href="${pageContext.request.contextPath}/input/8"><img
											src="resources/images/bottomBoard.jpg" />
											<div class="pit bottom">${pitStones[8]}</div> </a></td>
								</tr>
							</table>
						</td>

						<%-- player two score --%>
						<td>
							<div class="pit middle">${pitStones[7]}</div> <img
							src="resources/images/rightScore.jpg" />
						</td>
					</tr>
				</table>

				<br>
				<c:choose>
					<c:when test="${gameMessage != null}">
						<h2 class="message">${gameMessage}</h2>
					</c:when>
					<c:otherwise>
						<div class="ui buttons">
							<h4 class="ui button" style="color: black">Current Player:
								${currentPlayer}</h4>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="column">
				<div class="ui inverted segment">
					<div class="ui inverted accordion">
						<div class="title">
							<i class="dropdown icon"></i> Who Wins?
						</div>
						<div class="content">
							<p class="transition hidden">when the last stone lands in an
								own empty pit, the player captures this stone and all stones in
								the opposite pit (the other players' pit) and puts them in his
								own Mancala. The game is over as soon as one of the sides run
								out of stones. The player who still has stones in his/her pits
								keeps them and puts them in his/hers Mancala. The winner of the
								game is the player who has the most stones in his Mancala.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="black column">Game Developed by Terry Khudani
				Ramurebiwa</div>
		</div>

		<div class="row">
			<div class="column blue">
				<div class="big ui label">
					<i class="github icon"></i> https://github.com/RamsTerry
				</div>
				<div class="big ui label">
					<i class="mail icon purple "></i> realterryrams@gmail.com
				</div>
				<div class="big ui label">
					<i class="linkedin square icon blue"></i> Terry khudani Ramurebiwa
				</div>
			</div>
		</div>
	</div>
</body>
</html>