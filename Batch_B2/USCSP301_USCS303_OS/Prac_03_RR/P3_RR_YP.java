
import java.util.Scanner;
class P3_RR_YP
{
 public static void main(String args[])
{
 Scanner input = new Scanner(System.in);
 int i,j,k,q,sum = 0;
 System.out.print("Enter number of process:");
 int n= input.nextInt();
 int burstTime[] = new int[n];
 int waitingTime[] = new int[n]; 
 int turnAroundTime[] = new int[n];
 int a[] = new int[n]; 
 System.out.println("Enter burst Time of each process: ");
 for(i=0;i<n;i++)
{
 System.out.print("Enter burst Time for Process-P" + (i)+":");
 burstTime[i]=input.nextInt();
 a[i]=burstTime[i];
 }
 System.out.print("Enter Time quantum: ");
 q=input.nextInt();
 for(i=0;i<n;i++)
 waitingTime[i]=0;
int timer=0;//Current time
 //Keep traversing processes in round robin manner
 //until all of them are not done.
 do{
 for(i=0;i<n;i++){
 //If burst time of a process is greater than 0 then only need to process further
 if(burstTime[i]>q){
 //Increase the value of t i.e.shows how much time a process has been processed
 timer+=q;
 //Decrease the burst time of current process by quantum
 burstTime[i]-=q;
 for(j=0;j<n;j++){
 if((j!=i)&&(burstTime[j]!=0))
 waitingTime[j]+=q;
 }
 } //if ends
 
 //If burst time is smaller than or equal to quantum.Last cycle for this process
 else 
{
 //Increase the value of t i.e.shows how much time a process has been processed 
timer += burstTime[i];
 for(j=0;j<n;j++)
{
 if((j!=i)&&(burstTime[j]!=0))
 waitingTime[j]+=burstTime[i];
 }
 //As the process gets fully executed make its remaining burst time = 0
 burstTime[i]=0;
 }
 }//else ends
sum=0;
for(k=0;k<n;k++)
 sum+=burstTime[k];
 
 }while(sum!=0);
 //calculating turnAround Time by adding waitingTime + burstTime
 for(i=0;i<n;i++)
 turnAroundTime[i]=waitingTime[i]+a[i];
 float total=0;
 for(int m:waitingTime){
 total+=m;
 }
 float averagewaitingTime=total/n;
 total=0;
 for(int m:turnAroundTime){
 total+=m;
 }
 float averageturnAroundTime=total/n;
 // print on console the order of processes scheduled using Round-robin Algorithm
 System.out.println("RR Algorithm: ");
 System.out.format("%20s%20s%20s%20s\n", "ProcessId", "burstTime", "waitingTime","turnAroundTime");
 for(i=0;i<n;i++)
{
 System.out.format("%20s%20d%20d%20d\n", "P"+(i), a[i], 
waitingTime[i],turnAroundTime[i]);
 }
 System.out.format("%40s%20f%20f\n", "Average", 
averagewaitingTime,averageturnAroundTime);
 }
 }