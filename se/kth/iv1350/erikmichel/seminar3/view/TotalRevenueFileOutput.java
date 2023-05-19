/*
 * Copyright (c) 2016, Leif Lindbäck
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other materials provided
 * with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package se.kth.iv1350.erikmichel.seminar3.view;
/* Is supposed to print the total income to a file
 *
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.erikmichel.seminar3.model.TotalRevenueObserver;

/**
 * Prints log messages to a file. The log file will be in the current directory
 * and will be called
 * log.txt.
 */

public class TotalRevenueFileOutput implements TotalRevenueObserver {
    private double totalRevenue;

    /*
     * Creates a new observer of TotalRevenueFileOutput class with empty attributes
     * 
     */
    public TotalRevenueFileOutput() {
    }

    /*
     * Updates attribute totalRevenue and prints that value to file log.txt
     * 
     * @param totalRevenue this represents the current total revenue which is to be
     * printed to file log.txt
     */
    public void TotalRevenueUpdate(double totalRevenue) {
        this.totalRevenue = totalRevenue;
        PrintTotalRevenue();
    }

    /*
     * Prints current totalRevenue attribute to file log.txt
     */
    private void PrintTotalRevenue() {

        try {
            
            FileWriter myWriter = new FileWriter("log.txt");
            myWriter.write("Total Revenue :" + totalRevenue);
            myWriter.close();
            System.out.println("Successfully wrote to log.txt");
        } catch (IOException e) {
            System.out.println("An error occurred when attempting to print to file log.txt");
            e.printStackTrace();
        }
    }
}
