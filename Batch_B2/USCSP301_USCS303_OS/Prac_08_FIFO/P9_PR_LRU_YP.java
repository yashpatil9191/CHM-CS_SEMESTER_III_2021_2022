//Name: Yash patil
// Batch: B2
// PRN: 2020016400809191
// Date: 31 August,2021
// Prac-09: Page Replacement Algorithm(LRU)

import java.io.*;
import java.util.*;
public class P9_PR_LRU_YP
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		int frames,pointer = 0, hit = 0, fault = 0,ref_len;
		Boolean isFull = false;
		int buffer[];
		ArrayList<Integer>stack = new ArrayList<Integer>();
		int reference[];
		int mem_layout[][];
		System.out.print("Please enter the number of Frames: ");
		frames = scan.nextInt();

		System.out.print("Please enter the length of the References strings: ");
		ref_len = scan.nextInt();
		reference = new int[ref_len];
		mem_layout = new int[ref_len][frames];
		buffer = new int[frames];
		for(int j = 0; j < frames; j++)
			buffer[j] = -1;
			System.out.print("Please enter the references strings: ");
			for(int i = 0; i < ref_len; i++)
			{
				reference[i] = scan.nextInt();
			}
			System.out.println();
			for(int i = 0; i < ref_len; i++)
			{
				if(stack.contains(reference[i]))
				{
					stack.remove(stack.indexOf(reference[i]));
				}
				stack.add(reference[i]);
				int search = -1;
				for(int j = 0; j < frames; j++)
				{
					if(buffer[j] == reference[i])
					{
						search = j;
						hit++;
						break;
					}
				}
				if(search == -1)
				{
					if(isFull)
					{
						int min_loc = ref_len;
						for(int j = 0; j < frames; j++)
						{
							if(stack.contains(buffer[j]))
							{
								int temp = stack.indexOf(buffer[j]);
								if(temp < min_loc)
								{
									min_loc = temp;
									pointer = j;	
								}
							}
						}
					}
					buffer[pointer] = reference[i];
					fault++;
					pointer++;
					if(pointer == frames)
					{
						pointer = 0;
						isFull = true;
					}
				}
				for(int j = 0; j < frames; j++)
					mem_layout[i][j] = buffer[j];
			}
			for(int i = 0; i < frames; i++)
			{
				for(int j = 0; j < ref_len; j++)
					System.out.printf("%3d",mem_layout[j][i]);
				System.out.println();
			}

			System.out.println("The number of Hits: " + hit);
			System.out.println("Hit Ratio: " +(float)((float)hit/ref_len));
			System.out.println("The number of Faults: " + fault);
		}
}
