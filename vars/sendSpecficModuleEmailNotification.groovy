/**
 * @created 17/11/2020- 10:37
 * @author gmekala* @project taxilla-jenkins-shared-library
 */
import static com.taxilla.jenkins.components.Constants.*


def call() {
    if (currentBuild.currentResult == 'SUCCESS') {
        BG_Color = "#5bda65"
        Log = "false"
    } else {
        BG_Color = "#8B0000"
        Log = "true"
    }
    emailext attachLog: false, attachmentsPattern: '*.LOG', mimeType: 'text/html', body: """<!DOCTYPE html>
		<html>
			<head>
				<style>
					 table.blueTable {
					 table-layout: auto;
					 border: 1px solid #1C6EA4;
					 text-align: left;
					 border-collapse: collapse;
					 }
					 table.blueTable td {
					 font-size: 18px;
					 white-space:nowrap;
					 padding:10px;
					 border: 1px solid #AAAAAA;
					 }
					 table.blueTable tr:nth-child(even) {
					 /*background: #D0E4F5; */
					 }
					 table.blueTable thead tr {
					 background-color: $BG_Color;
					 text-align: center;
					 }
					 table.blueTable tbody tr td:last-child{
					 background-color:#f3f2f2;
					 }
				</style>
			</head>
			<body>
				<table class="blueTable">
					<thead>
						<tr>
							 <td colspan='2'>
							 <b>BUILD REPORT</b></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							 <td><strong>Build No</strong></td>
							 <td>$BUILD_NUMBER</td>
						</tr>
						<tr>
							 <td><strong>JAVA Version</strong></td>
							 <td>${JDK11_VERSION}</td>
						</tr>
						
						<tr>
							 <td><strong>Gradle version</strong></td>
							 <td>${GRADLE_VERSION}</td>
						</tr>
						<tr>
							 <td><strong>BRANCH NAME</strong></td>
							 <td>${params.Branch}</td>
						</tr>
																			
						<tr>
							 <td><strong>Module</strong></td>
							 <td>${params.ModuleType}</td>
						</tr>
						
				 </tbody>
				</table>
			 </body>
		</html>
		""", subject: "CI: Project Name -> / ${env.JOB_BASE_NAME} / Module: ${params.ModuleType} /build status on /${params.Branch} / branch is ${currentBuild.currentResult}", to: '$DEFAULT_RECIPIENTS'
}