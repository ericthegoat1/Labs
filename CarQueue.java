
import java.util.ArrayDeque;
import java.util.Random;

public class CarQueue {

	ArrayDeque<Integer> queue;

	Random movement;

	public CarQueue(){
		queue = new ArrayDeque<Integer>();

		movement = new Random();

		queue.add(movement.nextInt(4));
		queue.add(movement.nextInt(4));
		queue.add(movement.nextInt(4));
		queue.add(movement.nextInt(4));
		queue.add(movement.nextInt(4));
		queue.add(movement.nextInt(4));
	}




	public void addToQueue() {

		class QueueRunnable implements Runnable
		{


			@Override
			public void run() 
			{

				try {
					while (true)
					{
						queue.add(movement.nextInt(4));
						Thread.sleep(200);
					}

				}    catch (InterruptedException exception)
	            {
					exception.printStackTrace();
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      

				Runnable run = new QueueRunnable();
				Thread th = new Thread(run);
				th.start();
			}



			public int deleteQueue() {
				return queue.remove();
			}



		}


	
	
