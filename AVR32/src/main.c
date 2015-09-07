/**
 * AVR32 UC3 template for TTK4147
 */

// include header files for all drivers that have been imported from AVR Software Framework (ASF).
#include <asf.h>
#include <board.h>
#include <gpio.h>
#include <sysclk.h>
#include "busy_delay.h"
#include <stdio.h>
#include "stdio_usb.h"

// defines for USB UART
#define CONFIG_USART_IF (AVR32_USART2)

// defines for BRTT interface
#define TEST_A AVR32_PIN_PA31
#define RESPONSE_A AVR32_PIN_PA30
#define TEST_B AVR32_PIN_PA29
#define RESPONSE_B AVR32_PIN_PA28
#define TEST_C AVR32_PIN_PA27
#define RESPONSE_C AVR32_PIN_PB00

volatile bool A;
volatile bool B;
volatile bool C;
// declare interrupts
__attribute__((__interrupt__)) 
static void interrupt_J3(void);

void init()
{
	// board init
	sysclk_init();
	board_init();
	busy_delay_init(BOARD_OSC0_HZ);
	
	// interrupts init
	cpu_irq_disable();
    INTC_init_interrupts();
	INTC_register_interrupt(&interrupt_J3,   AVR32_GPIO_IRQ_3, AVR32_INTC_INT1);
	cpu_irq_enable();

	//  stdio init
	stdio_usb_init(&CONFIG_USART_IF);

	// Specify that stdout and stdin should not be buffered.

#if defined(__GNUC__) && defined(__AVR32__)
	setbuf(stdout, NULL);
	setbuf(stdin,  NULL);
#endif
}

/*********************************************************************
User decelerations
*********************************************************************/

/*********************************************************************
Interrupt routines
*********************************************************************/
__attribute__((__interrupt__)) 
static void interrupt_J3(void) 
{ 
		

		if ((gpio_get_pin_interrupt_flag(TEST_A))){
			gpio_clear_pin_interrupt_flag(TEST_A);
			A = true;
		}
		if ((gpio_get_pin_interrupt_flag(TEST_B))){
			gpio_clear_pin_interrupt_flag(TEST_B);
			B = true;
		}
		if ((gpio_get_pin_interrupt_flag(TEST_C))){
			gpio_clear_pin_interrupt_flag(TEST_C);
			C = true;
			
		}
}

/*********************************************************************
Functions
*********************************************************************/



int main(){
	init();
	gpio_configure_pin(TEST_A, GPIO_DIR_INPUT);
	gpio_configure_pin(RESPONSE_A, GPIO_DIR_OUTPUT | GPIO_INIT_HIGH);
	gpio_configure_pin(TEST_B, GPIO_DIR_INPUT);
	gpio_configure_pin(RESPONSE_B, GPIO_DIR_OUTPUT | GPIO_INIT_HIGH);
	gpio_configure_pin(TEST_C, GPIO_DIR_INPUT);
	gpio_configure_pin(RESPONSE_C, GPIO_DIR_OUTPUT | GPIO_INIT_HIGH);
	
	gpio_enable_pin_interrupt(TEST_A, GPIO_FALLING_EDGE );
	gpio_enable_pin_interrupt(TEST_B, GPIO_FALLING_EDGE );
	gpio_enable_pin_interrupt(TEST_C, GPIO_FALLING_EDGE );
	
	while(1){
		
			
		if (A){
			A = false;
			gpio_set_pin_low(RESPONSE_A);
			busy_delay_us(5);
			gpio_set_pin_high(RESPONSE_A);
		}
		if (B){
			B = false;
			gpio_set_pin_low(RESPONSE_B);
			busy_delay_us(5);
			gpio_set_pin_high(RESPONSE_B);
		}
		if (C){
			C = false;
			gpio_set_pin_low(RESPONSE_C);
			busy_delay_us(5);
			gpio_set_pin_high(RESPONSE_C);
		}
		
	}
}



//
//
//int main(){
//init();
//gpio_configure_pin(TEST_A, GPIO_DIR_INPUT);
//gpio_configure_pin(RESPONSE_A, GPIO_DIR_OUTPUT | GPIO_INIT_HIGH);
//gpio_configure_pin(TEST_B, GPIO_DIR_INPUT);
//gpio_configure_pin(RESPONSE_B, GPIO_DIR_OUTPUT | GPIO_INIT_HIGH);
//gpio_configure_pin(TEST_C, GPIO_DIR_INPUT);
//gpio_configure_pin(RESPONSE_C, GPIO_DIR_OUTPUT | GPIO_INIT_HIGH);
//
//while(1){
//
//if (gpio_pin_is_low(TEST_A)){
//gpio_set_pin_low(RESPONSE_A);
//busy_delay_us(5);
//gpio_set_pin_high(RESPONSE_A);
//}
//if (gpio_pin_is_low(TEST_B)){
//gpio_set_pin_low(RESPONSE_B);
//busy_delay_us(5);
//gpio_set_pin_high(RESPONSE_B);
//}
//if (gpio_pin_is_low(TEST_C)){
//gpio_set_pin_low(RESPONSE_C);
//busy_delay_us(5);
//gpio_set_pin_high(RESPONSE_C);
//
//}
//}
//}
//
//