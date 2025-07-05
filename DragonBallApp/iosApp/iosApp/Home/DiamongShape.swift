//
//  DiamongShape.swift
//  iosApp
//
//  Created by David FIGUERES FORTUNA on 29/6/25.
//

import SwiftUI

struct DiamondShape: Shape {
    
    func path(in rect: CGRect) -> Path {
        var path = Path()
        
        let top = CGPoint(x: rect.midX, y: rect.minY)
        let bottom = CGPoint(x: rect.midX, y: rect.maxY)
        let left = CGPoint(x: rect.minX, y: rect.midY)
        let right = CGPoint(x: rect.maxX, y: rect.midY)
        
        path.move (to: top)
        path.addLine (to: right)
        path.addLine (to: bottom)
        path.addLine (to: left)
        path.addLine(to: top)
        return path
        
    }
    
    
}
