package refactoringml.db;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "project", indexes = {@Index(columnList = "datasetName"), @Index(columnList = "projectName")})
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String datasetName;
	private String gitUrl;
	private String projectName;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateOfProcessing;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar finishedDate;

	private int commits;

	private int threshold;
	private long javaLoc;
	private int exceptionsCount;
	private int cleanedRows;

	private String lastCommitHash;

	@Deprecated // hibernate purposes
	public Project() {}

	public Project(String datasetName, String gitUrl, String projectName, Calendar dateOfProcessing, int commits, int threshold, long javaLoc, String lastCommitHash) {
		this.datasetName = datasetName;
		this.gitUrl = gitUrl;
		this.projectName = projectName;
		this.dateOfProcessing = dateOfProcessing;
		this.commits = commits;
		this.threshold = threshold;
		this.javaLoc = javaLoc;
		this.lastCommitHash = lastCommitHash;
	}

	public void setFinishedDate(Calendar finishedDate) {
		this.finishedDate = finishedDate;
	}

	public void setExceptions(int exceptionsCount) {
		this.exceptionsCount = exceptionsCount;
	}

	public void setCleanedRows(int cleanedRows) {
		this.cleanedRows = cleanedRows;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Project{" +
				"id=" + id +
				", datasetName='" + datasetName + '\'' +
				", gitUrl='" + gitUrl + '\'' +
				", projectName='" + projectName + '\'' +
				", dateOfProcessing=" + dateOfProcessing +
				", finishedDate=" + finishedDate +
				", commits=" + commits +
				", threshold=" + threshold +
				", javaLoc=" + javaLoc +
				", exceptionsCount=" + exceptionsCount +
				", cleanedRows=" + cleanedRows +
				", lastCommitHash='" + lastCommitHash + '\'' +
				'}';
	}
}
