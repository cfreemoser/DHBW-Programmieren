package de.dhbwka.java.exercise.threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;


public class DancingComponents extends JFrame implements MouseListener, MouseMotionListener, Runnable {
    private int lastX, lastY;
    private Graphics g;
    private ArrayList<Line> lines = new ArrayList<>();

    public DancingComponents() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setSize(200, 200);
        this.setVisible(true);
        this.g = this.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.lastX = e.getX();
        this.lastY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (lines.size() > 0) {
            this.removeMouseListener(this);
            this.removeMouseMotionListener(this);
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int x = e.getX(), y = e.getY();
        this.g.drawLine(this.lastX, this.lastY, x, y);
        Point lastPoint = new Point(this.lastX, this.lastY);
        Point newPoint = new Point(x, y);
        this.lastX = x;
        this.lastY = y;
        lines.add(new Line(lastPoint, newPoint, Color.black, 2));

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void doSomeShit() {
        clear();
        Random random = new Random();
        lines = lines.stream().map(line -> line.mutateLine(random.nextInt(getHeight()))).collect(Collectors.toCollection(ArrayList::new));
        lines.forEach(this::drawLine);

    }

    private void clear() {
        g.clearRect(0, 0, getWidth(), getHeight());
    }

    private void drawLine(Line line) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(line.getThinkness()));
        g.setColor(line.getLineColor());
        g.drawLine(line.getStartPoint().getX(),
                line.getStartPoint().getY(),
                line.getEndPoint().getX(),
                line.getEndPoint().getY());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            doSomeShit();
        }

    }
}
